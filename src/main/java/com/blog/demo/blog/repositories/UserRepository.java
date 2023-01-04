package com.blog.demo.blog.repositories;

import com.blog.demo.blog.entities.User;
import com.blog.demo.common.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {

}
