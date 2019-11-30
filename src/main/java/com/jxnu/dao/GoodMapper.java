package com.jxnu.dao;

import com.jxnu.pojo.Goods;

import java.util.List;

public interface GoodMapper {
    //查询出售中的商品
    List<Goods> queryUserSelling(int userid);
    //主页商品展示
    List<Goods> queryAllGood();
    //搜索栏搜索商品
    List<Goods> searchGoods(String searchGoodsName);
    //下架商品
    int unloadedGoods(int userid,int goodid);
    //查询所有用户已发布的商品中id最大的商品
    Goods searchMaxGoodId();
    //查询已下架的商品
    List<Goods> queryUserUnselling(int userid);
    //重新上架商品
    int onSaleAgain(int userid,int goodid);
    //发布新闲置商品
    int onSale(Goods good);
}
