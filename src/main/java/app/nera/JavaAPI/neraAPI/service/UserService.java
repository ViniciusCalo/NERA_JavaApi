package app.nera.JavaAPI.neraAPI.service;

import app.nera.JavaAPI.neraAPI.dto.LoginResponse;
import app.nera.JavaAPI.neraAPI.model.Role;
import app.nera.JavaAPI.neraAPI.model.UserModel;
import app.nera.JavaAPI.neraAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokeUtil jwtTokeUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Criar um novo usuario
    public UserModel createUser(String username, String useremail, String userpassword, Role role, String profilepicture){
        try {
            //verifica se o email já está registrado
            if (userRepository.findByUserEmail(useremail).isPresent()) {
                throw new RuntimeException("User already exists");
            }

            //verifica se o campo senha esta preenchido
            if (userpassword == null || userpassword.isEmpty()) {
                throw new RuntimeException("Password cannot be empty");
            }

            //hash da senha
            String hashedPassword = passwordEncoder.encode(userpassword);

            //create new user
            UserModel newUser = new UserModel(username, useremail, hashedPassword, profilepicture, role);
            return userRepository.save(newUser);
        } catch (Exception error) {
            throw new RuntimeException("Error creating user: ", error);
        }
    }

    //atualizar a foto de perfil do usuário
    public UserModel uploadProfilePic(Integer id, String profilepicture) {
        try {
            UserModel user = userRepository.getUserById(id);
            user.setProfilepicture(profilepicture);
            return userRepository.save(user);
        } catch (Exception error) {
            throw new RuntimeException("Error uploading profile picture: ", error);
        }
    }

    //Retorna a foto de perfil do usuario
    public String getProfilePicture(Integer id, String profilepicture) {
        try {
            UserModel user = userRepository.getUserById(id);
            return user.getProfilepicture();
        } catch (Exception error) {
            throw new RuntimeException("Error fetching profile picture", error);
        }
    }

    //fazendo o login de um usuario via email e senha
    public LoginResponse loginUser (String useremail, String userpassword, Role role) {

        //verifica se o usuario existe
        UserModel user = userRepository.findByUserEmail(useremail)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        //verifica a função
        if(!user.getRole().equals(role)) {
            throw new RuntimeException("invalid role");
        }

        //valida a senha
        if(!passwordEncoder.matches(userpassword, user.getUserpassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        //gera token
        String token = jwtTokeUtil.generateToken(user);

        return new LoginResponse(token, user.getUsername(), user.getProfilepicture());
    }
}
