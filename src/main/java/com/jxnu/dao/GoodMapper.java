package com.jxnu.dao;

import com.jxnu.pojo.Goods;

import java.util.List;

public interface GoodMapper {
    List<Goods> queryUserSelling(int userid);
    List<Goods> queryAllGood();
    List<Goods> searchGoods(String searchGoodsName);
    Goods searchMaxGoodId();
}
