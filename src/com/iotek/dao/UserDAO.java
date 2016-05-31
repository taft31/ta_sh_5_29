package com.iotek.dao;

import com.iotek.dto.UserDTO;
import com.iotek.model.UsersEntity;

import java.util.List;

/**
 * Created by taft on 2016/5/29.
 */
public interface UserDAO {
    boolean isUserNameRepeat(String userName);
    boolean createUser(UsersEntity usersEntity);
    boolean updateUser(UsersEntity usersEntity);
    UsersEntity checkLogin(UsersEntity usersEntity);
    List<UserDTO> listUser(UsersEntity usersEntity);
}
