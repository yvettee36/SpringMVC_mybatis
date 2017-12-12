package com.eurasia.service;

import com.eurasia.pojo.ItemsCustom;
import com.eurasia.pojo.ItemsQueryVo;

import java.util.List;

/**
 * Created by yvettee on 2017/12/3.
 */
public interface ItemsService {
    //商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    //根据id查询商品信息
    public ItemsCustom findItemsById(Integer id) throws Exception;

    //修改商品信息
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

    public void deleteItems(String[] items_id) throws Exception;
}
