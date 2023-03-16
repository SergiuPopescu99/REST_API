package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }
    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookById=bookRepository
                .findBookByBookID(book.getBookID());
        if(bookById.isPresent())
        {
            throw new IllegalStateException("book id already taken");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {

        boolean exists=bookRepository.existsById(bookId);
        if(!exists)
        {
            throw new IllegalStateException("Book with id "+ bookId+ " does not exist");

        }
        bookRepository.deleteById(bookId);
    }
}


