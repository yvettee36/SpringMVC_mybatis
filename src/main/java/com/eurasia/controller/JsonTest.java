package com.eurasia.controller;

import com.eurasia.pojo.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yvettee on 2017/12/11.
 */
@Controller
public class JsonTest {
    //请求json串(商品信息),输出json()
    @RequestMapping("/requestJson")
    //@RequestBody表示将请求的商品信息json串转成ItemsCustom对象
    //@ResponseBody表示将ItemsCustom对象转成json输出
    public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {

        return itemsCustom;
    }

    //请求key/value，输出json
    @RequestMapping("/responseJson")
    public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){

        //@ResponseBody将itemsCustom转成json输出
        return itemsCustom;
    }
}
