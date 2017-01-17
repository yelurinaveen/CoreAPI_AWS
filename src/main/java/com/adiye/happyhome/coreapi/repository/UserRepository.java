package com.adiye.happyhome.coreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adiye.happyhome.coreapi.model.User;

/**
 * Created by nyeluri on 11/17/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
