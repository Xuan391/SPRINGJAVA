package com.example.JAVASPRING1.jwt;

import com.example.JAVASPRING1.security.CustomUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@Slf4j // co che ghi log cua lombok
public class JwtTokenProvider {
    @Value("${javaspring.jwt.secret}")
    private String JWT_SECRET;
    @Value("${javaspring.jwt.expiration}")
    private int JWT_EXPIRATION;

//    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    //tao jwt tu thong tin user
    public String generateToken(CustomUserDetails customUserDetail){
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(customUserDetail.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // lay thong tin user tu jwt
    public String getUserNameFromJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    // validate JWT
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT Token");
        }catch (IllegalArgumentException ex){
            log.error("JWT claims String is empty");
        }
        return false;
    }
}
