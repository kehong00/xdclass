package cn.codewoo.utils.jwt;

import cn.codewoo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64UrlCodec;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;

/**
 * @author kehong
 */
public class JwtUtils {
    /**
     * subject 签发人
     * expire 过期时间
     * appSecret 秘钥
     */
    public static  String subject;
    public static Duration expire;
    public static String appSecret;

    /**
     * 生成jwtToken
     * @param user 用户主体
     * @return String 签发的token
     */
    public static String geneJsonWebToken(User user){
        Jwts.claims();
        if (user == null || user.getId() == null){
            return null;
        }
        String token = Jwts.builder()
                .setSubject(subject)
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expire.toMillis()))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(appSecret.getBytes())).compact();
        return token;
    }

    /**
     * 校验token同时获得负载信息
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try{
            final Claims claims = Jwts.parser().setSigningKey(appSecret).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}
