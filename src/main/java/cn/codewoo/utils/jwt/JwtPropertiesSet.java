package cn.codewoo.utils.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author kehong
 */
@Component
public class JwtPropertiesSet {
    public JwtPropertiesSet(JwtProperty properties){
        JwtUtils.appSecret = properties.getAppSecret();
        JwtUtils.expire = properties.getExpire();
        JwtUtils.subject = properties.getSubject();
    }
}
