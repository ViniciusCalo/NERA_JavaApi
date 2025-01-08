package app.nera.JavaAPI.neraAPI.service;

import app.nera.JavaAPI.neraAPI.model.TeacherModel;
import app.nera.JavaAPI.neraAPI.model.UserModel;
import app.nera.JavaAPI.neraAPI.repository.TeacherRepository;
import app.nera.JavaAPI.neraAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder teachercpfEnconder;

    public TeacherModel registerUserAsATeacher(UserModel userid, String teachercpf) {
        try {

            //verificando se o professor ja existe, pelo id de usuario dele
            if(userRepository.findById(userid).isPresent()) {
                throw new RuntimeException("Teacher Already exists");
            }

            //verifica se o campo teachercpf esta preenchido
            if (teachercpf == null || teachercpf.isEmpty()) {
                throw new RuntimeException("Teacher CPF cannot be empty");
            }
            //encriptando o cpf do professor
            String hashedTeacherCPF = teachercpfEnconder.encode(teachercpf);

            //register user as a teacher
            TeacherModel newTeacher = new TeacherModel(userid, hashedTeacherCPF);
            return teacherRepository.save(newTeacher);
        } catch (Exception error) {
            throw new RuntimeException("Error registering user as a teacher: ", error);
        }
    }

}
