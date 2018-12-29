package com.zp.mall.controller;


import com.zp.mall.entity.ItemCustom;
import com.zp.mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zp
 * @date 2018/11/16
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * controller的方法有三种返回值
     * 1、ModelAndView
     *
     * 2、String（字符串）
     * 使用Model
     *
     * 3、void
     * 使用HttpServletRequest request, HttpServletResponse response
     * 路径要使用全路径
     *
     * 4、重定向(数据不可共享，不是同一个请求)
     * 方法返回值：String  "redirect:url"
     *
     * 5、forward转发(数据可共享，是同一个请求)
     * 方法返回值：String  "forward:url"
     *
     */
//    @RequestMapping("/queryItems")
//    public ModelAndView queryItems() throws Exception {
//        // 调用service查询商品
//        List<ItemCustom> itemCustoms = itemService.findItemsList(null);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("items", itemCustoms);
//        modelAndView.setViewName("goods/itemsList");
//        return modelAndView;
//
//    }

    @RequestMapping(value = "/queryItems", method = RequestMethod.GET)
    public void queryItems(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // 调用service查询商品
        List<ItemCustom> itemCustoms = itemService.findItemsList(null);
        request.setAttribute("items", itemCustoms);
        request.getRequestDispatcher("/WEB-INF/views/goods/itemsList.jsp").forward(request, response);
    }

    @RequestMapping("/queryItems123")
    public String queryItems123(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        return "redirect:/queryItems"; // 重定向
//        return "forward:/queryItems"; // 转发

    }




}
