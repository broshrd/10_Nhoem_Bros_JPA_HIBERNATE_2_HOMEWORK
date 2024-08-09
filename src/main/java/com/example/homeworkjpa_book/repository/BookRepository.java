package com.example.homeworkjpa_book.repository;

import com.example.homeworkjpa_book.model.Books;
import com.example.homeworkjpa_book.requestbody.BookRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
@PersistenceContext
@Transactional

public class BookRepository {

    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Books insertBook(BookRequest books) {
        Books books1 = new Books();
//        books1.setId(null);
        books1.setAuthor(books.getAuthor());
        books1.setTitle(books.getTitle());
        books1.setDescription(books.getDescription());
        books1.setPublicationYear(books.getS_dob());
        entityManager.persist(books1);
        return books1;
    }

    public List<Books> getAllBook() {
        return entityManager.createQuery("SELECT b FROM Books b", Books.class).getResultList();
    }

    public Books getBookById(UUID id) {
        return entityManager.find(Books.class,id);
    }
    public List<Books> getBookByTitle(String bookTitle) {
        TypedQuery<Books> res = entityManager.createQuery("SELECT b FROM Books b WHERE lower(b.title) ilike  lower(:bookTitle)", Books.class);
        res.setParameter("bookTitle", "%" + bookTitle.toLowerCase() + "%");
        return res.getResultList();
        }

    public Books updateBook( UUID id, BookRequest books) {
        Books books1 = entityManager.find(Books.class,id);
        entityManager.detach(books1);
        books1.setAuthor(books.getAuthor());
        books1.setTitle(books.getTitle());
        books1.setDescription(books.getDescription());
        books1.setPublicationYear(books.getS_dob());
        entityManager.merge(books1);
        return books1;
    }
    public String deleteBook(UUID id) {
      Books books = entityManager.find(Books.class,id);
       entityManager.remove(books);
       return "delete book"+ books.getTitle() +" successfully";
    }
}
