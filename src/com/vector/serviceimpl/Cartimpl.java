package com.vector.serviceimpl;

import com.vector.entity.VECTORY_CART;
import com.vector.service.Cart;
import com.vector.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Cartimpl implements Cart {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public int insert(VECTORY_CART cart) {
        String sql = "insert into lmonkey_cart values(null,?,?,?,?,?,?,?,1)";

        int count = template.update(sql,
                cart.getCart_p_filename(),
                cart.getCart_p_name(),
                cart.getCart_p_price(),
                cart.getCart_quantity(),
                cart.getCart_p_stock(),
                cart.getCart_p_id(),
                cart.getCart_u_id());
        return count;
    }

    @Override
    public List<VECTORY_CART> getCart(String id) {
        String sql = "select * from lmonkey_cart where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
        List<VECTORY_CART> list = template.query(sql, new BeanPropertyRowMapper<VECTORY_CART>(VECTORY_CART.class),id);
        return list;
    }
    @Override
    public VECTORY_CART getCartShop(String id) {
        String sql = "select * from lmonkey_cart where CART_ID=? and CART_VALID=1 order by CART_ID desc";
        VECTORY_CART cart = null;
        try {
            cart = template.queryForObject(sql, new BeanPropertyRowMapper<VECTORY_CART>(VECTORY_CART.class),id);
        } catch (DataAccessException e) {
            return null;
        }
        return cart;
    }
    @Override
    public VECTORY_CART getCartShop(String uid, String pid) {
        String sql = "select * from lmonkey_cart where CART_U_ID=? and CART_P_ID=? and CART_VALID=1 order by CART_ID desc";
        VECTORY_CART cart = null;
        try {
            cart = template.queryForObject(sql, new BeanPropertyRowMapper<VECTORY_CART>(VECTORY_CART.class),uid,Integer.parseInt(pid));
        } catch (DataAccessException e) {
            return null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public int updatenum(int cart_id, int newcount) {
        String sql = "update lmonkey_cart set cart_quantity=? where cart_id=? ";
        int count = template.update(sql, cart_id, newcount);
        return count;
    }

    @Override
    public int getDeleteDD(int id) {
        String sql = "delete from lmonkey_cart where cart_id=?";
        int update = template.update(sql, id);
        return update;
    }
}

