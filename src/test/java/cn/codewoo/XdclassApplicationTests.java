package cn.codewoo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
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
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
