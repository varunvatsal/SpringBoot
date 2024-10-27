package com.api.book.bootRestApi;

import com.api.book.bootRestApi.dao.BookRepo;
import com.api.book.bootRestApi.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =  SpringApplication.run(RestApiApplication.class, args);

		BookRepo bookRepo = applicationContext.getBean(BookRepo.class);
		Iterable<Book> books = bookRepo.findAll();
		books.forEach(ele -> {
			System.out.println(ele);
		});

		System.out.println("Hello World!");
	}

}
