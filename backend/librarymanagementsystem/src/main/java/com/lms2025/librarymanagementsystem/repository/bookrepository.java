package com.lms2025.librarymanagementsystem.repository;

import com.lms2025.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepository extends JpaRepository<Book, Long> {

    //custom queries can be added here
    Book findByTitle(String title);
    
}
