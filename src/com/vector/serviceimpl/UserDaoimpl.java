package com.vector.serviceimpl;

import com.vector.entity.User;
import com.vector.service.UserDao;
import com.vector.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoimpl implements UserDao {
    //Spring给Jdbc的封装
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());


    /**
     * 添加用户
     * @param u
     * @return
     */
    @Override
    public int regist(User u) {
        String sql = "insert into booktown_user (USER_ID,USER_NAME,USER_PASSWORD,USER_BIRTHDAY,USER_IDENITY_CODE,USER_EMAIL,USER_MOBLE,USER_ADDRESS,USER_STATUS,USER_SEX)  values(?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?,?)";
        int count = template.update(sql, u.getUSER_ID(),
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBLE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS(),
                u.getUSER_SEX());
        return count;
    }


    /**
     * 通过ID查询用户
     */
    @Override
    public User selectById(String id) {

        User user = new User();
        String sql = "select * from booktown_user where USER_ID=?";
        User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        return user1;
    }


    /**
     * 查询所用用户
     */

    @Override
    public List<User> selectAll() {
        String sql = "select * from booktown_user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    /**
     * 分页查询
     *
     * @param condition
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from booktown_user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from booktown_user  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }

    @Override
    public int update(User u) {
        String sql = "update  booktown_user set USER_NAME=?,USER_PASSWORD=?,USER_BIRTHDAY=?,USER_IDENITY_CODE=DATE_FORMAT(?,'%Y-%m-%d'),USER_EMAIL=?,USER_MOBLE=?,USER_ADDRESS=?,USER_STATUS=?,USER_SEX=? where USER_ID = ?";
        int count = template.update(sql,
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBLE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS(),
                u.getUSER_SEX(),u.getUSER_ID());
        return count;
    }

    @Override
    public int del(String id) {
        String sql = "delete from booktown_user where USER_ID = ? and USER_STATUS != 2";
        int update = template.update(sql, id);
        return update;
    }

    @Override
    public User selectByName(String id) {
        String sql = "select * from booktown_user where USER_ID = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        System.out.println(user);
        return user;
    }

    @Override
    public User selectByNM(String userName, String passWord) {
        String sql = "select * from booktown_user where USER_ID = ? and USER_PASSWORD = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userName,passWord);
        } catch (DataAccessException e) {
            return null;
        }
        System.out.println(user);
        return user;
    }

    @Override
    public User selectAdmin(String userName, String passWord) {
        String sql = "select * from booktown_user where USER_ID=? and USER_PASSWORD = ?";
        User user1 = null;
        try {
            user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),userName,passWord);
        } catch (DataAccessException e) {
            return null;
        }
        System.out.println(user1);
        return user1;
    }
}

