package com.someone.repository;

import com.someone.entity.Hobby;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface HobbyRepository extends CrudRepository<Hobby,Integer> {

    @Query(value = "SELECT * FROM hobby WHERE id = ?1", nativeQuery = true)
    List<Hobby> findByID(Integer user_id);

    @Query(value = "SELECT * FROM hobby WHERE name = ?1", nativeQuery = true)
    List<Hobby> findByName(String name);

}
