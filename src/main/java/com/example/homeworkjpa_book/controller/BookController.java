package com.example.homeworkjpa_book.controller;

import com.example.homeworkjpa_book.model.dto.Response;
import com.example.homeworkjpa_book.repository.BookRepository;
import com.example.homeworkjpa_book.requestbody.BookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@RestController
@RequestMapping

public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("api/Insert")
    public ResponseEntity<?> insertBook(@RequestBody BookRequest bookRequest){
        return Response.BookResponse(
                "Insert book successfully",
                bookRepository.insertBook(bookRequest)
        );
    }

    @GetMapping("api/GetAll_books")
    public ResponseEntity<?> getAllBooks(){
            return Response.RessponseALl(
                    "Fetch all",
                    bookRepository.getAllBook(),
                    bookRepository.getAllBook().size()
            );
    }
    @GetMapping("api/searchById/{id}")
    public ResponseEntity<?> getBookById(@PathVariable UUID id){
        return Response.BookResponse(
                "Get book successfully",
                bookRepository.getBookById(id)
        );
    }

    @GetMapping("{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title){
        return Response.BookResponse(
                "Get book successfully",
                bookRepository.getBookByTitle(title)
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable UUID id , @RequestBody BookRequest bookRequest){
        return Response.BookResponse(
                "Update Book successfully",
                bookRepository.updateBook(id,bookRequest)
        );
    }

    @DeleteMapping("api/deleteBook_by_id/{id}")
    public String deleteBook(@PathVariable UUID id){
      return bookRepository.deleteBook(id);
    }
}
