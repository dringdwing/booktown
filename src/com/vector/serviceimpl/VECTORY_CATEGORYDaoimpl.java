package com.vector.serviceimpl;

import com.vector.entity.VECTORY_CATEGORY;
import com.vector.service.VECTORY_CATEGORYDao;
import com.vector.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VECTORY_CATEGORYDaoimpl implements VECTORY_CATEGORYDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public List<VECTORY_CATEGORY> selectCat(String flag) {
        if(flag != null && flag.equals("father")){
            String sql = "select * from category where CATE_PARENT_ID = 0";
            List<VECTORY_CATEGORY> list = template.query(sql, new BeanPropertyRowMapper<VECTORY_CATEGORY>(VECTORY_CATEGORY.class));
            return list;
        }else {
            String sql = "select * from category where CATE_PARENT_ID != 0";
            List<VECTORY_CATEGORY> list = template.query(sql, new BeanPropertyRowMapper<VECTORY_CATEGORY>(VECTORY_CATEGORY.class));
            return list;
        }
    }

    public List<VECTORY_CATEGORY> selectAll() {
        String sql = "select * from category";
        List<VECTORY_CATEGORY> list = template.query(sql, new BeanPropertyRowMapper<VECTORY_CATEGORY>(VECTORY_CATEGORY.class));
        return list;
    }
    @Override
    public int insert(VECTORY_CATEGORY cate) {
        String sql = "insert into category (CATE_ID,CATE_NAME,CATE_PARENT_ID)  values(null,?,?)";
        int update = template.update(sql, cate.getCATE_NAME(), cate.getCATE_PARENT_ID());
        return update;
    }

    @Override
    public VECTORY_CATEGORY selectById(int id) {
        String sql = "select * from category where CATE_ID=?";
        VECTORY_CATEGORY cate = null;
        try {
            cate = template.queryForObject(sql, new BeanPropertyRowMapper<VECTORY_CATEGORY>(VECTORY_CATEGORY.class), id);
        } catch (DataAccessException e) {
            return null;
        }
        return cate;
    }

    @Override
    public int update(VECTORY_CATEGORY cate) {
        String sql = "update  category set CATE_NAME=?,CATE_PARENT_ID=? where CATE_ID = ?";
        int count = template.update(sql,

                cate.getCATE_NAME(),
                cate.getCATE_PARENT_ID(),
                cate.getCATE_ID()
                );
        return count;
    }

    @Override
    public int del(int id) {
        String sql = "delete from category where CATE_ID = ?";
        int update = template.update(sql, id);
        return update;
    }

}
