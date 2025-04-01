package app.nera.JavaAPI.neraAPI.controller;

import app.nera.JavaAPI.neraAPI.dto.RegistrationResponse;
import app.nera.JavaAPI.neraAPI.dto.UserRegistrationRequest;
import app.nera.JavaAPI.neraAPI.model.Role;
import app.nera.JavaAPI.neraAPI.model.StudentModel;
import app.nera.JavaAPI.neraAPI.model.TeacherModel;
import app.nera.JavaAPI.neraAPI.model.UserModel;
import app.nera.JavaAPI.neraAPI.service.StudentService;
import app.nera.JavaAPI.neraAPI.service.TeacherService;
import app.nera.JavaAPI.neraAPI.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Autowired
    public UserController(UserService userService, TeacherService teacherService, StudentService studentService) {
        this.userService = userService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request) {
        try {
            // Validação para professores
            if (request.getRole() == Role.TEACHER &&
                    (request.getTeacherCpf() == null || request.getTeacherCpf().trim().isEmpty())) {
                return ResponseEntity.badRequest()
                        .body("CPF do professor é obrigatório.");
            }

            // Cria o usuário
            UserModel newUser = userService.createUser(request);

            // Tratamento baseado na role
            if (newUser.getRole() == Role.TEACHER) {
                TeacherModel registeredTeacher = teacherService.registerUserAsATeacher(
                        newUser.getUserid(),
                        request.getTeacherCpf()
                );
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new RegistrationResponse(
                                "Professor registrado com sucesso",
                                newUser,
                                registeredTeacher
                        ));
            }

            if (newUser.getRole() == Role.STUDENT) {
                UserModel registeredStudent = studentService.registerUserAsAStudent(newUser).getUserid();
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new RegistrationResponse(
                                "Estudante registrado com sucesso",
                                newUser,
                                registeredStudent
                        ));
            }

            // Caso para outras roles (se houver)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RegistrationResponse(
                            "Usuário registrado com sucesso",
                            newUser,
                            null
                    ));

        } catch (Exception e) {
            // Log do erro (considerar usar um logger adequado)
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("Erro interno no servidor: " + e.getMessage());
        }
    }

}
