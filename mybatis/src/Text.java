import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Text {

    public static void main(String[] args){
      // test1();
//        test2();
//        test3();
        testInsert();
    }


    private static void testInsert() {
        SqlSession sqlSesstion = SqlSessionFactoryUtils.getSqlSesstion();
        User user = new User();
        user.setUsername("zhang");
        user.setSex("s");
        user.setBirthday(new Date());
        user.setAddress("sdf");
         int result =  sqlSesstion.insert("insertUser",user);
        System.out.print(result);
        sqlSesstion.commit();
        sqlSesstion.close();
    }


    private static void test3() {
        SqlSession sqlSesstion = SqlSessionFactoryUtils.getSqlSesstion();
        List<User> user = sqlSesstion.selectList("getUserByName","张");
        System.out.print(user.get(0).getUsername());
        sqlSesstion.close();
    }

    private static void test2() {
        SqlSession sqlSesstion = SqlSessionFactoryUtils.getSqlSesstion();
        User user = sqlSesstion.selectOne("getUserById",1);
        System.out.print(user.getUsername());
        sqlSesstion.close();
    }

    public static void test1(){
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sessionFactory =  sessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession = sessionFactory.openSession();
            User user = sqlSession.selectOne("getUserById",1);
            System.out.print(user.getUsername());
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
