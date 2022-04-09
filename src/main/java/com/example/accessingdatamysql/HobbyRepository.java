package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface HobbyRepository extends CrudRepository<Hobby,Integer> {

    @Query(value = "SELECT * FROM hobby WHERE id = ?1", nativeQuery = true)
    List<Hobby> findByID(Integer user_id);

}
