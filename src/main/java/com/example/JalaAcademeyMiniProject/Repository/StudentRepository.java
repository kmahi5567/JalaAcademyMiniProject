package com.example.JalaAcademeyMiniProject.Repository;


import com.example.JalaAcademeyMiniProject.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
