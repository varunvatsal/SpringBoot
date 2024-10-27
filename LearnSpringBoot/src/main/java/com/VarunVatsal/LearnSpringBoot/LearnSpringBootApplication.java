package com.VarunVatsal.LearnSpringBoot;

import com.VarunVatsal.LearnSpringBoot.dao.UserRepo;
import com.VarunVatsal.LearnSpringBoot.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringBootApplication.class, args);

		UserRepo userRepo = context.getBean(UserRepo.class);

		//saving single user
//		User newUser = new User("sahil", "rana", "sahilrana@gmail.com", "chennai");
//		User userReturn = userRepo.save(newUser);

		//saving multiple user
//		User user1 = new User("abhik", "jindal", "abhik@123.com", "chadigarh");
//		User user2 = new User("nimit", "jindal", "nimit@123.com", "pune");
//		List<User> users = List.of(user1, user2);
//		Iterable<User> saveAllReturn = userRepo.saveAll(users);
//
//		saveAllReturn.forEach( user -> {
//			System.out.println(user);
//		});

		//how to get the data
//		Iterable<User> foundByIdUser =  userRepo.findAllById();
		//Optional<User> returnVal = userRepo.findById(id) -> returns Optional container
		//Iterable<User> returnVal =  userRepo.findAll() -> return the table
		//find data based ont other columns(non-primary key columns), using custom finder methods or derived query methods
		List<User> returnValOne = userRepo.findByFirst_name("varun");
		returnValOne.forEach(ele -> {
			System.out.println(ele);
		});
		List<User> returnValTwo = userRepo.findByEmail("varunvatsal963@gmail.com");
		returnValTwo.forEach(ele -> {
			System.out.println(ele);
		});

		Iterable<User> users = userRepo.findAll();
		Iterator<User> iterator = users.iterator();
//		while (iterator.hasNext()) {
//			User user = iterator.next();
//			System.out.println(user);
//		}

//		iterator.forEachRemaining(new Consumer<User>() {
//			public void accept(User user) {
//				System.out.println(user);
//			}
//		});
		
//		iterator.forEachRemaining(user -> {
//			System.out.println(user);
//		});


		//updating
		//update the id of user of id = 5
//		Optional<User> userWithIdFive = userRepo.findById(5);
//		if (userWithIdFive.isEmpty()) throw new NoSuchElementException("user entry no; found");
//		User user = userWithIdFive.get();
//		user.setLast_name("tiwari");
//		userRepo.save(user);
//		System.out.println(user);


		//how to delete
//		userRepo.deleteAll(); // can pass an iterable of users
//		userRepo.deleteById();
//		userRepo.deleteAllById();




//		System.out.println(userReturn);
		System.out.println("done");
	}

}
