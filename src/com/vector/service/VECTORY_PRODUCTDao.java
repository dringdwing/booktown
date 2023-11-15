package com.vector.service;


import com.vector.entity.VECTORY_PRODUCT;

import java.util.ArrayList;
import java.util.List;

public interface VECTORY_PRODUCTDao {
    /**
     * 添加产品
     * @param p
     * @return
     */
    int insert(VECTORY_PRODUCT p);

    /**
     * 查询所有
     * @return
     */
    List<VECTORY_PRODUCT> selectAll();

    /**
     * 通过父id查询
     * @param fid
     * @return
     */
    List<VECTORY_PRODUCT> selectAllByFid(int fid);

    /**
     * 通过子id查询
     * @param cid
     * @return
     */
    List<VECTORY_PRODUCT> selectAllByCid(int cid);

    /**
     *通过id查询（商品详情页）
     * @param id
     * @return
     */
    VECTORY_PRODUCT selectById(int id);

    List<VECTORY_PRODUCT> selectAllById(ArrayList<Integer> ids);
}
