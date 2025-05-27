package com.lms2025.librarymanagementsystem.repository;

import com.lms2025.librarymanagementsystem.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepository extends JpaRepository<User, Long> {
    
    //custom queries can be added here
    user findByUsername(String username);
    
}
