package com.eurasia.controller;

import com.eurasia.controller.validation.ValidGroup1;
import com.eurasia.pojo.ItemsCustom;
import com.eurasia.pojo.ItemsQueryVo;
import com.eurasia.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yvettee on 2017/11/30.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    // 商品分类
    //itemtypes表示最终将方法返回值放在request中的key
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes() {

        Map<String, String> itemTypes = new HashMap<String, String>();
        itemTypes.put("101", "数码");
        itemTypes.put("102", "母婴");

        return itemTypes;
    }

    //查询商品信息
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
        //调用service查找数据库，查询商品列表，这里使用静态数据模拟
        List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request.setAttribute
        modelAndView.addObject("itemsList", list);

        //指定视图
        modelAndView.setViewName("/items/itemsList");
        return modelAndView;
    }

    //商品信息修改页面展示
//    @RequestMapping("/editItems")
    //限制http请求方法
    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    // @RequestParam里边指定request传入参数名称和形参进行绑定。
    // 通过required属性指定参数是否必须要传入
    // 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
    public String editItems(Model model, @RequestParam(value = "id", required = true) Integer items_id) throws Exception {
        //调用service根据id查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);

//        modelAndView.setViewName("/items/editItems");
        //通过形参中的model将model数据传到页面,modelAndView.addObject("itemsCustom", itemsCustom);
        model.addAttribute("itemsCustom", itemsCustom);
        return "/items/editItems";
    }

    //查询商品信息，输出json
    ///itemsView/{id}里边的{id}表示占位符，通过@PathVariable获取占位符中的参数，
    //如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
    @RequestMapping("/itemsView/{id}")
    public @ResponseBody
    ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception {

        //调用service查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        return itemsCustom;
    }

    //商品信息修改提交
    // 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
    // bindingResult接收校验出错信息
    // 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    //value = {ValidGroup1.class}指定使用ValidGroup1接口的校验
    //@ModelAttribute("items")可以指定pojo回显到页面在request中的key
    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Model model, Integer id, @Validated(value = {ValidGroup1.class}) ItemsCustom itemsCustom,
                                  BindingResult bindingResult, MultipartFile items_pic//用来接收商品的图片
    ) throws Exception {
        //获取校验错误信息
        if (bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError objectError : allErrors) {
                //输出
                System.out.println(objectError.getDefaultMessage());
            }
            //将错误信息传到页面
            model.addAttribute("allErrors", allErrors);
            //出错重新到商品修改页面
            return "/items/editItems";
        }
        String originalFilename = items_pic.getOriginalFilename();//图片原始名称
        //上传图片
        if (items_pic != null && originalFilename != null && originalFilename.length() > 0) {

            String pic_path = "E:\\upload\\img\\";//存储图片的物理路径

            //新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新图片
            File newFile = new File(pic_path + newFileName);

            //将内存中的数据写入磁盘
            items_pic.transferTo(newFile);

            //将新图片名称写到itemsCustom中
            itemsCustom.setPic(newFileName);
        }


        //调用service更新商品信息，页面需要将商品信息传到此方法
        itemsService.updateItems(id, itemsCustom);
        //重定向
        return "forward:queryItems.action";
    }

    //批量删除商品信息
    @RequestMapping("/deleteItems")
    public String deleteItems(String[] items_id) throws Exception {
        //调用service批量删除商品
        itemsService.deleteItems(items_id);
        return "forward:queryItems.action";
    }

    //批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
    @RequestMapping("/editItemsQuery")
    public ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo) throws Exception {
        //调用service查找数据库，查询商品列表，这里使用静态数据模拟
        List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request.setAttribute
        modelAndView.addObject("itemsList", list);
        //指定视图
        modelAndView.setViewName("/items/editItemsQuery");
        return modelAndView;
    }

    //批量修改商品提交
    //通过ItemsQueryVo接收批量数据，将商品信息存储到itemsQueryVo中itemsList属性中
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {

        return "success";
    }
}
