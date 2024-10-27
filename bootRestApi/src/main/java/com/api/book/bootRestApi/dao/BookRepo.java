package com.api.book.bootRestApi.dao;

import com.api.book.bootRestApi.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer>{

}
