package com.adiye.happyhome.coreapi.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adiye.happyhome.coreapi.exception.EntityNotFoundException;
import com.adiye.happyhome.coreapi.model.User;
import com.adiye.happyhome.coreapi.repository.UserRepository;

/**
 * Created by nyeluri on 11/15/16.
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user){
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        try{
            userRepository.delete(userId);
        }
        catch(EmptyResultDataAccessException e){
            throw new EntityNotFoundException(User.class.getSimpleName(),System.currentTimeMillis());
        }
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findOne(userId);
        if(user==null){
            throw new EntityNotFoundException(User.class.getSimpleName(),System.currentTimeMillis());
        }
        return user;
    }

}
