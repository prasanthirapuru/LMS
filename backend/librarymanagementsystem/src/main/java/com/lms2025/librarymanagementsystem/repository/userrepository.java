package com.lms2025.librarymanagementsystem.repository;

import com.lms2025.librarymanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User, Long> {
    
    //custom queries can be added here
    User findByUsername(String username);
    
}
