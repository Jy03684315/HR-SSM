package com.show.service;

import com.show.model.User;

/**
 * Created by Show on 2018/7/25.
 */
public interface UserService {
    void addUser(User user);
    User getUserByNamePass(User user);
    User getUserByName(User user);
}
