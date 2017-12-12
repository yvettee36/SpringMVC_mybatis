package com.eurasia.mapper;


import com.eurasia.pojo.ItemsCustom;
import com.eurasia.pojo.ItemsQueryVo;

import java.util.List;

/**
 * Created by yvettee on 2017/12/3.
 */
public interface ItemsMapperCustom {
    //商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
