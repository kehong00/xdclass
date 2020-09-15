package cn.codewoo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author kehong
 * 微信相关配置类
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "wxpay")
public class WeChatConfig {
    //公众号id
    private String appId;
    //公众号秘钥
    private String appSecret;
}
