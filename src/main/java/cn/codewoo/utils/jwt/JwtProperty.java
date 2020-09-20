package cn.codewoo.utils.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author kehong
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperty {
    /**
     * subject 签发人
     * expire 过期时间
     * appSecret 秘钥
     */
    private String subject;
    private Duration expire;
    private String appSecret;
}
