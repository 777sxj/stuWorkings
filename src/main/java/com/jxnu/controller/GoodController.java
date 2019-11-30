package com.jxnu.controller;

import com.jxnu.pojo.Goods;
import com.jxnu.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    //查询用户正在出售中的商品
    @RequestMapping(value = "/userSelling")
    public String queryUserSelling(Model model,HttpSession session){
        String userId = (String) session.getAttribute("userid");
        int userid = Integer.parseInt(userId);
        List<Goods> userSellingList = goodService.queryUserSelling(userid);
        model.addAttribute("userSellingList",userSellingList);
        return "userIdleView";
    }

    //下架商品
    @RequestMapping(value = "/unloadedGoods")
    public String unloadedGoods(HttpServletRequest request){
        HttpSession session = request.getSession();
        String goodId = request.getParameter("goodid");
        String userId = (String) session.getAttribute("userid");
        int goodid = Integer.parseInt(goodId);
        int userid = Integer.parseInt(userId);
        boolean b = goodService.unloadedGoods(userid,goodid);
        System.out.println("商品"+goodid+"下架"+b);
        return "userIdleView";
    }

    //查询用户已下架商品
    @RequestMapping(value = "/userUnselling")
    public String queryUserUnselling(Model model,HttpSession session){
        String userId = (String) session.getAttribute("userid");
        int userid = Integer.parseInt(userId);
        List<Goods> userUnsellingList = goodService.queryUserUnselling(userid);
        model.addAttribute("userUnsellingList",userUnsellingList);
        return "userIdleView";
    }

    //重新上架商品
    @RequestMapping(value = "/onSaleAgain")
    public String onSaleAgain(HttpServletRequest request){
        HttpSession session = request.getSession();
        String goodId = request.getParameter("goodid");
        String userId = (String) session.getAttribute("userid");
        int goodid = Integer.parseInt(goodId);
        int userid = Integer.parseInt(userId);
        boolean b = goodService.onSaleAgain(userid,goodid);
        System.out.println("商品"+goodid+"重新上架"+b);
        return "userIdleView";
    }

    //上架新闲置商品
//    @RequestMapping(value = "/onSale")
//    public String onSale(Model model, HttpServletRequest request){
//        HttpSession session = request.getSession();
//        String userId = (String) session.getAttribute("userid");
//        int userid = Integer.parseInt(userId);
//        Goods maxIdGood = goodService.searchMaxGoodId();
//        int maxGoodid = maxIdGood.getGoodid();
//        Goods good = new Goods();
//
//        good.setGoodid(maxGoodid+1);
//        good.setUserid(userid);
//        good.setTypeid(userid);
//        good.setGoodname("..");
//        good.setPrice(1);
//        good.setDescripe("..");
//        good.setReserve(1);
//        good.setImgroad("..");
//        good.setSalestutas(1);
//
//        boolean b = goodService.onSale(good);
//        return null;
//    }


}
