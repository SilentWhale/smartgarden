package com.liuying.user.dao;

import com.liuying.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luo on 22/02/2017.
 */
@Repository
public interface UserMapper {
    int addUser(User user);
    List<User> selectUser(User user);
    int updateUser(User user);
}
