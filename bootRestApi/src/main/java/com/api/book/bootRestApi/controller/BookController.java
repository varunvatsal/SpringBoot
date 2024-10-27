package com.api.book.bootRestApi.controller;


import com.api.book.bootRestApi.model.Book;
import com.api.book.bootRestApi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

//    @RequestMapping(value="/books", method = RequestMethod.GET)
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

        List<Book> books = bookService.findAllBooks();
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    //find book
    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        Book obj = bookService.findBookById(id);
        if(obj == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    //add a book
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
//      return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.addBook(book));
        Book obj = null;
        try{
            obj = bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(obj);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/addBooks")
    public List<Book> addBooks(@RequestBody List<Book> books){
        return this.bookService.addBooks(books);
    }

    //delete book handler
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") int id){
        Book obj = bookService.deleteBookById(id);
        if(obj == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    //to update the book
    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book){
        return this.bookService.updateBookDetails(id, book);
    }

}
