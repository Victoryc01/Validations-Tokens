package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JWTUtil {

            private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        public static String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                    .signWith(key)
                    .compact();

        }

        public static String validateToken(String token) {
            try {
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
                return "Verification pass";
            } catch (Exception e) {
                return "Verification fails: "+ e.getMessage();
            }
        }

}
