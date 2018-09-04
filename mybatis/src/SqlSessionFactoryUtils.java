import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionFactoryUtils {

    static SqlSessionFactory sqlSessionFactory  = null;

    static {
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSesstion(){
        return sqlSessionFactory.openSession();
    }

//    public static void
}
