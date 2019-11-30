package com.jxnu.service;

import com.jxnu.pojo.Goods;

import java.util.List;

public interface GoodService {
    List<Goods> queryUserSelling(int userid);
    List<Goods> queryAllGood();
    List<Goods> searchGoods(String searchGoodsName);
    Goods searchMaxGoodId();
    boolean unloadedGoods(int userid,int goodid);
    List<Goods> queryUserUnselling(int userid);
    boolean onSaleAgain(int userid,int goodid);
    boolean onSale(Goods good);
}
