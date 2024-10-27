package com.VarunVatsal.LearnSpringBoot.dao;

import com.VarunVatsal.LearnSpringBoot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    //learn JPQL hibernate 
    //https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#reference
    //?1 this means that method first argument will be used there
    @Query(value = "select * from user where first_name=?1", nativeQuery = true)
    public List<User> findByFirst_name(String first_name);

    public List<User> findByEmail(String email);
}
