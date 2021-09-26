package com.test.hplus.repository;


import com.test.hplus.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("select u from User u where u.username=:name")
    public User serachByName(@Param("name") String username);
}
