package cn.thinknovo.pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 方法名就是mapper.xml文件中的id
    // 返回类型就是mapper.xml文件中的resultType
    // 返回的单一对象还是集合，由我们的sql决定
    // 我们通过sql来决定如果是单一对象，则在返回类型上写入对应返回类型
    // 如果sql返回的是集合，那么返回类型需要加上list
    // 如果有多个sql配置，那么就需要多个定义的方法

    /**
     * 查询user表中的所有数据，包含id、username、password
     * @return  返回list列表
     */
    List<User> selectUser();

    /**
     * 基于一个user对象在完成一条记录的插入
     * @param user  对象中封装对应的属性值
     */
    void insertUser(User user);

    /**
     * 基于一个password的值完成插入一条数据
     * @param password
     */
    void insertUserByPassword(String password);

    /**
     * 基于key-value的方式插入一条数据
     * @param map
     */
    void insertUserByUserAndPassword(Map<String, String> map);

    /**
     * 基于一个user对象的id来更新user对象中的用户名和密码
     * @param user
     */
    void updateUser(User user);

    /**
     * 基于一个主键id来删除一条记录
     * @param id
     */
    void deleteUser(String id);
}
