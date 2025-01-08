package app.nera.JavaAPI.neraAPI.repository;

import app.nera.JavaAPI.neraAPI.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {

}
