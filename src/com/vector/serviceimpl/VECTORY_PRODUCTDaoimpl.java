package com.vector.serviceimpl;


import com.vector.entity.VECTORY_PRODUCT;
import com.vector.service.VECTORY_PRODUCTDao;
import com.vector.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class VECTORY_PRODUCTDaoimpl implements VECTORY_PRODUCTDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public int insert(VECTORY_PRODUCT p) {

        String sql = "insert into product(PRODUCT_NAME,PRODUCT_DESCRIPTION,PRODUCT_PRICE,PRODUCT_STOCK,PRODUCT_FID,PRODUCT_CID,PRODUCT_FILENAME) " +
                "values(?,?,?,?,?,?,?)";
        int update = template.update(sql, p.getPRODUCT_NAME(),
                p.getPRODUCT_DESCRIPTION(),
                p.getPRODUCT_PRICE(),
                p.getPRODUCT_STOCK(),
                p.getPRODUCT_FID(),
                p.getPRODUCT_CID(),
                p.getPRODUCT_FILENAME());
        return update;
    }

    @Override
    public List<VECTORY_PRODUCT> selectAll() {

        String sql = "select * from product";
        List<VECTORY_PRODUCT> list = template.query(sql, new BeanPropertyRowMapper<VECTORY_PRODUCT>(VECTORY_PRODUCT.class));
        return list;
    }

    @Override
    public List<VECTORY_PRODUCT> selectAllByFid(int fid) {
        String sql = "select * from product where PRODUCT_FID = ?";
        List<VECTORY_PRODUCT> list = template.query(sql, new BeanPropertyRowMapper<VECTORY_PRODUCT>(VECTORY_PRODUCT.class), fid);
        return list;
    }

    @Override
    public List<VECTORY_PRODUCT> selectAllByCid(int cid) {
        String sql = "select * from product where PRODUCT_CID = ?";
        List<VECTORY_PRODUCT> list = template.query(sql, new BeanPropertyRowMapper<VECTORY_PRODUCT>(VECTORY_PRODUCT.class), cid);
        return list;
    }

    @Override
    public VECTORY_PRODUCT selectById(int id) {
        String sql = "select * from product where PRODUCT_ID = ?";
        VECTORY_PRODUCT list = null;
        try {
            list = template.queryForObject(sql, new BeanPropertyRowMapper<VECTORY_PRODUCT>(VECTORY_PRODUCT.class), id);
        } catch (DataAccessException e) {
           return null;
        }
        return list;
    }
    @Override
    public List<VECTORY_PRODUCT> selectAllById(ArrayList<Integer> ids) {
        List<VECTORY_PRODUCT> list = null;
        for (int i = 0; i < ids.size(); i++) {
            String sql = "select * from product where PRODUCT_ID = ?";
            list = template.query(sql, new BeanPropertyRowMapper<VECTORY_PRODUCT>(VECTORY_PRODUCT.class), ids.get(i));
        }
        System.out.println(list);
        return list;
    }
}
