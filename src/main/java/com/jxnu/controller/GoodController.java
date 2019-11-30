package com.jxnu.controller;

import com.jxnu.pojo.Goods;
import com.jxnu.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodController {
    @Autowired
    @Qualifier("GoodServiceImp")
    private GoodService goodService;

    @RequestMapping(value = "/main")
    public String showAllGood(HttpSession session){
        List<Goods> showAllGoodList = goodService.queryAllGood();
        session.setAttribute("showAllGoodList",showAllGoodList);
        return "main";
    }

    @RequestMapping(value = "/searchGoods")
    public String searchGoods(Model model, String searchGoodsName){
        List<Goods> searchGoodsList = goodService.searchGoods(searchGoodsName);
        model.addAttribute("searchGoodsList",searchGoodsList);
        return "main";
    }
    //用户正在出售中的商品
    @RequestMapping(value = "/UserSelling")
    public String queryUserSelling(Model model,HttpSession session){
        String userId = (String) session.getAttribute("userid");
        int userid = Integer.parseInt(userId);
        List<Goods> userSellingList = goodService.queryUserSelling(userid);
        model.addAttribute("userSellingList",userSellingList);
        return "userIdleView";
    }

}
