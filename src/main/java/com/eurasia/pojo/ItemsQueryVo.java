package com.eurasia.pojo;

import java.util.List;

/**
 * Created by yvettee on 2017/12/3.
 */
//商品包装对象
public class ItemsQueryVo {
    //商品信息
    private Items items;

    //为了系统可扩展性，对原始生成的po进行扩展
    private ItemsCustom itemsCustom;
    private List<ItemsCustom> itemsList;

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }
}
