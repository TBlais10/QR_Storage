package com.qr_storeage.QR_StoragePt2.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    @Value("${jwt.secret}")
    private String secret;

    public String getUserIdFromToken (String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    public Claims getAllClaimFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
}
