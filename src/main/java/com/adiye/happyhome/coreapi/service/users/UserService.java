package com.adiye.happyhome.coreapi.service.users;

import com.adiye.happyhome.coreapi.model.User;

/**
 * Created by nyeluri on 11/15/16.
 */
public interface UserService {

    public void createUser(User user);

    public void deleteUser(Long userId);

    public User getUser(Long userId);
}
