package com.vector.service;

import com.vector.entity.VECTORY_CART;

import java.util.List;

public interface Cart {
    int insert(VECTORY_CART cart);

    List<VECTORY_CART> getCart(String uid);

    /**
     * 得到购物车是否有已有商品有的话购物页面加1
     * @param uid
     * @param pid
     * @return
     */
    VECTORY_CART getCartShop(String uid, String pid);

    /**
     * 更新商品数量
     * @param cart_id
     * @param newcount
     * @return
     */
    int updatenum(int cart_id, int newcount);

    int getDeleteDD(int parseInt);

    VECTORY_CART getCartShop(String id);
}
