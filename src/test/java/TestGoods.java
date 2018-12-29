import com.zp.mall.entity.Goods;
import com.zp.mall.mapper.GoodsDAOMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author zp
 * @date 2018/11/17
 */
public class TestGoods {
    public static void main(String[] args) {
    }

    @Test
    public void getGoodsPageTest() {
        int skip = 4;
        int size=2;
        try (SqlSession session = MybatisUtil.getSession()) {
            GoodsDAOMapper bookdao = session.getMapper(GoodsDAOMapper.class);
            List<Goods> goods = bookdao.getGoodsPager(skip, size);
            for (Goods good : goods) {
                System.out.println(good.getName());
            }
        }
    }

    @Test
    public void getGoodsByIdTest() {
        SqlSession session=MybatisUtil.getSession();
        try {
            GoodsDAOMapper bookdao=session.getMapper(GoodsDAOMapper.class);
            Goods goods=bookdao.getGoodsById(1);
            Assert.assertEquals(1, goods.getId());
        } finally {
            session.close();
        }
    }

    @Test
    public void getGoodsCountTest() {
        SqlSession session=MybatisUtil.getSession();
        try {
            GoodsDAOMapper bookdao=session.getMapper(GoodsDAOMapper.class);
            Assert.assertEquals(9, bookdao.getGoodsCount());
        } finally {
            session.close();
        }
    }

    @Test
    public void insertTest() {
        SqlSession session=MybatisUtil.getSession();
        try {
            Goods entity=new Goods();
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装江浙沪皖顺丰包邮");
            entity.setPrice(108);
            entity.setPicture("nopic.jpg");
            GoodsDAOMapper bookdao=session.getMapper(GoodsDAOMapper.class);
            Assert.assertEquals(1, bookdao.insert(entity));
        } finally {
            session.close();
        }
    }

    @Test
    public void deleteTest() {
        SqlSession session=MybatisUtil.getSession();
        try {
            GoodsDAOMapper bookdao=session.getMapper(GoodsDAOMapper.class);
            Assert.assertEquals(1, bookdao.delete(12));
        } finally {
            session.close();
        }
    }

    @Test
    public void update() {
        SqlSession session=MybatisUtil.getSession();
        try {
            GoodsDAOMapper bookdao=session.getMapper(GoodsDAOMapper.class);
            Goods entity=bookdao.getGoodsById(13);
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装");
            entity.setPrice(107);
            entity.setPicture("nopicture.jpg");

            Assert.assertEquals(1, bookdao.update(entity));
        } finally {
            session.close();
        }
    }

}
