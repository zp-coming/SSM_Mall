package com.zp.mall.mapper;

import com.zp.mall.entity.ItemCustom;
import com.zp.mall.entity.ItemsQueryVo;

import java.util.List;

public interface ItemCustomMapper {

    List<ItemCustom> findItemsList(ItemsQueryVo itemsQueryVo);
}
