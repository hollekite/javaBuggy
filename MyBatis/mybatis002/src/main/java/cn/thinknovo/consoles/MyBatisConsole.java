package cn.thinknovo.consoles;

import cn.thinknovo.pojos.User;
import cn.thinknovo.pojos.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisConsole {
    /*
    1.加入驱动到pom文件中，一个mybatis，一个mysql连接池
    2.创建pojo对象，此对象和数据库中的表名、字段名、类型相同
    3.添加mybatis.xml配置文件到resources的根目录(通过脚手架完成, 在这里可以添加自定义的目录)
    4.添加Mapper.xml配置文件到pojo文件夹下
    5.在pojo对应的目录下，创建一个接口
      此接口中创建的方法规则，(1)方法名就是Mapper.xml中的id
                             (2)方法返回类型就是Mapper.xml中resultType
    6.创建控制器，读取mybatis.xml内容，mybatis.xml会根据配置项自动关联所有的Mapper.xml文件
      读取入口固定代码：
                Reader reader = Resources.getResourceAsReader("mybatis.xml");
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                SqlSession session = sqlSessionFactory.openSession();

                ibatis  apache   tomcat  struts fileupload

     */
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper UserMapper = session.getMapper(UserMapper.class);
//
//
            // 在mybatis中通过session处理增删改查的时候，调用的字符串是接口中的方法，不是xml文件中的id
            // 使用的UserMapper的selectUser方法
//            List<User> list = session.selectList("selectUser");
//            for(User user : list) {
//                System.out.println(user.getUsername());
//            }

//            User user = new User();
//            user.setUsername("think3");
//            user.setPassword("999");
//            UserMapper.insertUser(user);

//            List<User> list = UserMapper.selectUser();
//            System.out.println(list);
//            Map<String, String> map = new HashMap<>();
//            map.put("username","think6");
//            map.put("password","123456");
//            UserMapper.insertUserByUserAndPassword(map);
//            User user = new User();
//            user.setId(6);
//            user.setUsername("think60");
//            user.setPassword("600");
//            UserMapper.updateUser(user);

            UserMapper.deleteUser("6");

            session.commit();
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
