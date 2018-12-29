package com.zp.mall.service;

import com.zp.mall.entity.Goods;
import com.zp.mall.mapper.GoodsDAOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品业务实现
 *
 * @author zp
 * @date 2018/11/17
 */
//自动添加到Spring容器中
@Service
public class GoodsServiceImpl implements GoodsService {

    //自动装配
    @Autowired
    private GoodsDAOMapper goodsDAOMapper;

    //分页
    @Override
    public List<Goods> getGoodsPager(int pageNO, int size) {
        int skip = (pageNO - 1) * size;
        return goodsDAOMapper.getGoodsPager(skip, size);
    }

    //获得单个产品对象
    @Override
    public Goods getGoodsById(int id) {
        return goodsDAOMapper.getGoodsById(id);
    }

    //获得商品总数
    @Override
    public int getGoodsCount() {
        return goodsDAOMapper.getGoodsCount();
    }

    //添加
    @Override
    public int insert(Goods entity) {
        return goodsDAOMapper.insert(entity);
    }

    //删除单个
    @Override
    public int delete(int id) {
        return goodsDAOMapper.delete(id);
    }

    //删除多个
    @Override
    public int deletes(int[] ids) {
        int rows = 0;
        for (int id : ids) {
            rows += delete(id);
        }
        return rows;
    }

    //更新
    @Override
    public int update(Goods entity) {
        return goodsDAOMapper.update(entity);
    }

}
