import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author zp
 * @date 2018/11/17
 */
public abstract class MybatisUtil {

    private static SqlSessionFactory getSqlSessionFactory(){
        // 获得环境配置文件流
        InputStream config = MybatisUtil.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        // 创建sql会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        return factory;
    }

    //获得会话
    public static SqlSession getSession(){
        return getSqlSessionFactory().openSession(true);
    }

    /**
     * 获得得sql会话
     * @param isAutoCommit 是否自动提交，如果为false则需要sqlSession.commit();rollback();
     * @return sql会话
     */
    public static SqlSession getSession(boolean isAutoCommit){
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}
