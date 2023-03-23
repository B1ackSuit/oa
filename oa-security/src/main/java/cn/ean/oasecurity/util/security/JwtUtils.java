package cn.ean.oasecurity.util.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

/**
 * @FileName JwtUtils
 * @Author ean
 * @Date 2023/3/9 19:45
 **/
@Component
public class JwtUtils {

    /**
     * 载荷部分包含了一组声明（claims）
     * "sub"（Subject）：JWT 所代表的实体
     */
    private static final String CLAIM_KEY_USERNAME = Claims.SUBJECT;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username) {
        Date now = new Date();
        String encodedSecret = Base64.getUrlEncoder().encodeToString(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, encodedSecret)
                .compact();
    }

    /**
     * 验证token是否有效和到期
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String refreshExpiredToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();

        return generateToken(username);
    }

    public boolean isTokenExpired(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * 从token中获取登录的用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        String username;

        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return username;
    }

    /**
     * 从token中获取负载中的声明
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {

        Claims claims = null;

        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException |
                 UnsupportedJwtException |
                 MalformedJwtException |
                 SignatureException |
                 IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        return claims;
    }


}
