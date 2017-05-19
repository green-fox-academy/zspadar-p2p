package com.greenfox.repository;

import com.greenfox.model.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by zsuzsanna.padar on 2017. 05. 18..
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
