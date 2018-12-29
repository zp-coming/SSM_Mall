package com.zp.mall.mapper;

import com.zp.mall.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zp
 * @date 2018/11/17
 */
public interface GoodsDAOMapper {
    /**
     * 获得商品信息并分页
     */
    List<Goods> getGoodsPager(@Param("skip") int skip, @Param("size") int size);

    /**
     * 获得单个商品通过编号
     */
    Goods getGoodsById(int id);

    /**
     * 获得商品总数
     */
    int getGoodsCount();

    /*
     * 新增加商品
     */
    int insert(Goods entity);

    /**
     * 删除商品
     */
    int delete(int id);

    /**
     * 修改商品
     */
    int update(Goods entity);
}
