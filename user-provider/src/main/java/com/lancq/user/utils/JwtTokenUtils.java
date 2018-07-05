package com.lancq.user.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/5
 **/
public class JwtTokenUtils {
    private static Key generatorKey(){
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;
        byte[] bin = DatatypeConverter.parseBase64Binary("abcdefg");
        Key key = new SecretKeySpec(bin,sa.getJcaName());
        return key;
    }

    public static String generatorToken(Map<String,Object> payLoad){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return Jwts.builder()
                    .setPayload(objectMapper.writeValueAsString(payLoad))
                    .signWith(SignatureAlgorithm.HS256, generatorKey())
                    .compact();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Claims phaseToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(generatorKey()).parseClaimsJws(token);
        return claimsJws.getBody();
    }

    public static void main(String[] args) {
        System.out.println(generatorKey());
    }
}
