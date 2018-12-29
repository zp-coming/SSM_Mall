package com.zp.mall.service;


import com.zp.mall.entity.ItemCustom;
import com.zp.mall.entity.ItemsQueryVo;

import java.util.List;

public interface ItemService {
    List<ItemCustom> findItemsList(ItemsQueryVo itemsQueryVo);
}
