package com.imtoocai.diary.repo;

import com.imtoocai.diary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByUserName(String userName);

    List<User> findByEmail(String email);

    User findAllByUserId(Integer uid);


}
