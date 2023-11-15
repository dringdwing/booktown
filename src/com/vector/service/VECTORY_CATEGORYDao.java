package com.vector.service;

import com.vector.entity.VECTORY_CATEGORY;

import java.util.List;

public interface VECTORY_CATEGORYDao {

    /**
     * 查询分类、子分类和父分类
     * @param flag flag=father flag=chid
     * @return
     */
    List<VECTORY_CATEGORY> selectCat(String flag);
    /**
     * 查询所有分类
     * @return
     */
    List<VECTORY_CATEGORY> selectAll();

    /**
     * 添加分类
     * @param cate
     * @return
     */
    int insert(VECTORY_CATEGORY cate);

    VECTORY_CATEGORY selectById(int id);

    /**
     *
     * @param cate
     * @return
     */
    int update(VECTORY_CATEGORY cate);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int del(int id);
}
