package app.nera.JavaAPI.neraAPI.repository;

import app.nera.JavaAPI.neraAPI.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
