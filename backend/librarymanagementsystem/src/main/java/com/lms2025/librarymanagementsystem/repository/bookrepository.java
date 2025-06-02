package com.lms2025.librarymanagementsystem.repository;

import com.lms2025.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bookrepository extends JpaRepository<Book, Long> {

    //custom queries can be added here
    //Book findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByTitleContainingIgnoreCase(String title);
    
}
