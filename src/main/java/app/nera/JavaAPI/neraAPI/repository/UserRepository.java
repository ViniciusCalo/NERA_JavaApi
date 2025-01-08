package app.nera.JavaAPI.neraAPI.repository;

import app.nera.JavaAPI.neraAPI.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUserEmail(String useremail);
    Optional<UserModel> findByUserName(String username);

    UserModel getUserById(Integer userid);

    Optional<Object> findById(UserModel userid);
}
