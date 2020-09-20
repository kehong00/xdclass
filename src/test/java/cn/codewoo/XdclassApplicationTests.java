package cn.codewoo;

import cn.codewoo.entity.User;
import cn.codewoo.mapper.UserMapper;
import cn.codewoo.utils.jwt.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.SQLException;

@SpringBootTest
class XdclassApplicationTests {
    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads() {
    }

    @Test
    void dataSource_test(){
        String str = "test,man,20,wu@kehong.xyz$test2,man,22,kehong00@163.com$test3,man,kehong@aj";
        String[] strings = str.split("\\$");
        for (String s : strings) {
//            System.out.println(s);
            String[] split = s.split(",");
            String name = split[0];
            System.out.println(split[split.length - 1]);
            if (split[split.length - 1].matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")){
                System.out.println(true);
            }
        }
    }

    @Test
    void jwtUtils_test(){
        User user = new User();
        user.setId(1);
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setHeadImg("http://www.codewoo.cn/img/head.png");
        user.setName("kehong");
        System.out.println(JwtUtils.geneJsonWebToken(user));
    }


}
class Person{
    private String name;
    private String sex;
    private Integer age;
    private String email;
}