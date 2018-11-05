package com.imtoocai.diary.repo;

import com.imtoocai.diary.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<user,Integer> {

}
