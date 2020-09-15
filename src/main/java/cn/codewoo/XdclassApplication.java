package cn.codewoo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kehong
 */
@SpringBootApplication
@MapperScan("cn.codewoo.mapper")
@EnableSwagger2
public class XdclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdclassApplication.class, args);
    }

}
