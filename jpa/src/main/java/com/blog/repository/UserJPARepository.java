package com.blog.repository;

import com.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lidu on 2017/8/19.
 */
public interface UserJPARepository extends CrudRepository<User,Long> {

}
