package com.experiment.mapper;

import com.experiment.pojo.User;

public interface UserMapper {
    User findUserByEmailAndPassword(User user);
}
