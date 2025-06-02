package com.lms2025.librarymanagementsystem.service;

import com.lms2025.librarymanagementsystem.model.Book;
import com.lms2025.librarymanagementsystem.repository.Bookrepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Bookservice {
    
    private final Bookrepository bookRepository;

    public Bookservice(Bookrepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setAvailable(updatedBook.isAvailable());
            return bookRepository.save(book);
        }).orElse(null); 
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }


    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }


}
