package com.api.book.bootRestApi.service;

import com.api.book.bootRestApi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import com.api.book.bootRestApi.dao.BookRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;



    //returns all the book in the repo
    public List<Book> findAllBooks(){
        List<Book> books = new ArrayList<Book>();
        bookRepo.findAll().forEach(books::add);
        return books;
    }

    //return book depending upon the id passed
    public Book findBookById(int id){
        Optional<Book> book = bookRepo.findById(id);
//        if(book.isPresent()){
//            return book.get();
//        }
//        return null;
        return book.orElse(null);

    }

    //adding a single book
    public Book addBook(Book book){
        Book obj = new Book(book.getTitle(), book.getAuthor());
        return bookRepo.save(obj);
    }

    public List<Book> addBooks(List<Book> books){
        List<Book> obj = new ArrayList<>();
        bookRepo.saveAll(books).forEach(obj::add);
        return obj;
    }

    public Book deleteBookById(int id){
        Optional<Book> obj = bookRepo.findById(id);
        if(obj.isEmpty()){
            return null;
        }
        bookRepo.deleteById(id);
        return obj.orElse(null);
    }


    public Book updateBookDetails(int id, Book book){
        Book obj = bookRepo.findById(id).get();
        obj.setTitle(book.getTitle());
        obj.setAuthor(book.getAuthor());
        bookRepo.save(obj);
        return obj;
    }
}
