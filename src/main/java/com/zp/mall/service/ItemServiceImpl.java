package com.zp.mall.service;

import com.zp.mall.entity.ItemCustom;
import com.zp.mall.entity.ItemsQueryVo;
import com.zp.mall.mapper.ItemCustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zp
 * @date 2018/11/15
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemCustomMapper itemCustomMapper;

    @Override
    public List<ItemCustom> findItemsList(ItemsQueryVo itemsQueryVo) {
        return itemCustomMapper.findItemsList(itemsQueryVo);
    }
}
