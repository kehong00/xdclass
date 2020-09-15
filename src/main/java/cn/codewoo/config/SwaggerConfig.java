package cn.codewoo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @author kehong
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfo("微信支付项目","整合微信支付","1.0",
                "http://www.codewoo.cn",ApiInfo.DEFAULT_CONTACT,"Apache2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",new ArrayList<VendorExtension>());
    }

    @Bean
    @Autowired
    public Docket docket(ApiInfo apiInfo){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        return docket.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.codewoo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
