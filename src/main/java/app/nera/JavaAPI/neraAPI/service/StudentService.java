package app.nera.JavaAPI.neraAPI.service;

import app.nera.JavaAPI.neraAPI.model.StudentModel;
import app.nera.JavaAPI.neraAPI.model.UserModel;
import app.nera.JavaAPI.neraAPI.repository.StudentRepository;
import app.nera.JavaAPI.neraAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public StudentModel registerUserAsAStudent(UserModel userid) {
        try {
            // verifica se student ja existe
            if(userRepository.findById(userid).isPresent()) {
                throw new RuntimeException("Student already exists");
            }

            //register user as a student
            StudentModel newStudent = new StudentModel(userid);
            return studentRepository.save(newStudent);
        } catch (Exception error) {
            throw new RuntimeException("Error Registering user as a student" + error);
        }
    }

}
