package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "library/books")
public class BookController {
    private final BookService bookService;
@Autowired
        public BookController(BookService bookService)
    {
        this.bookService=bookService;
    }
    @GetMapping
        public List<Book>getBooks()
    {
        return bookService.getBooks();
    }
    @PostMapping
    public void registerStudent(@RequestBody Book book)
    {
        bookService.addNewBook(book);
    }
    @DeleteMapping(path = "{bookId}")
    public void deleteStudent(@PathVariable("bookId") Long bookId)
    {
        bookService.deleteBook(bookId);
    }
//   @PutMapping(path = {"bookId"})
//    public  void updateAuthor(
//
//       @PathVariable("bookId") Long bookID,
//        @RequestParam(required = false) String author)
//       {
//           bookService.updateBook(bookID,author);
//       }
//   }
}
