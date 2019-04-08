package com.example.demo.respository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User,Long> {
//    @Query("SELECT r from #{#entityName} r where r.username =?1")
//    User myFindUserByUsername(String username);
    User findByUsername(String username);
}
