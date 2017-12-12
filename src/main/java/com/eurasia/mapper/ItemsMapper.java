package com.eurasia.mapper;

import com.eurasia.pojo.Items;

public interface ItemsMapper {
    void deleteByPrimaryKey(Integer items_id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
}