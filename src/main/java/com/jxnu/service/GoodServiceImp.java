package com.jxnu.service;

import com.jxnu.dao.GoodMapper;
import com.jxnu.pojo.Goods;

import java.util.List;

public class GoodServiceImp implements GoodService{
    private GoodMapper goodMapper;

    public void setGoodMapper(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    public List<Goods> queryUserSelling(int userid) {
        return goodMapper.queryUserSelling(userid);
    }

    public List<Goods> queryAllGood() {
        return goodMapper.queryAllGood();
    }

    public List<Goods> searchGoods(String searchGoodsName) {
        return goodMapper.searchGoods(searchGoodsName);
    }

    public Goods searchMaxGoodId() {
        return goodMapper.searchMaxGoodId();
    }
}
