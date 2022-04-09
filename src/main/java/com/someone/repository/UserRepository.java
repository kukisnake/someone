package com.someone.repository;

import com.someone.entity.Hobby;
import com.someone.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    @Query(value = "SELECT * FROM hobby WHERE id = ?1", nativeQuery = true)
    List<Hobby> getHobby(Integer user_id);

}
