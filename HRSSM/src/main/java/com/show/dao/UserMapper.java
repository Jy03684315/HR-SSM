package com.show.dao;

import com.show.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Show on 2018/7/25.
 */
@Repository
public interface UserMapper {
    void addUser(User user);
    User getUserByNamePass(User user);
    User getUserByName(User user);
}
