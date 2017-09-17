package com.blog.repository;

import com.blog.domain.User;

import java.util.List;

/**
 * Created by lidu on 2017/8/12.
 */
public interface UserRepository {

    /**
     * 保存修改用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 获取用户根据ID
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUser();

}
