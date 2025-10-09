package com.example.JalaAcademeyMiniProject.Repository;



import com.example.JalaAcademeyMiniProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
