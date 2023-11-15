package com.vector.service;

import com.vector.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 注册用户
     * @param user
     * @return
     */
    int regist(User user);

    /**
     * 通过ID查询用户
     * @return
     */
    User selectById(String id);
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();


    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int del(String id);

    /**
     * 查找用户
     * @param id
     * @return
     */
    User selectByName(String id);

    User selectByNM(String userName, String passWord);

    User selectAdmin(String userName, String passWord);
}

