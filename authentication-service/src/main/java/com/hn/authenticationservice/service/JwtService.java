package com.hn.authenticationservice.service;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expirationTime}")
    private long expirationTime;

    private final static String issuer = "hustedu";

    public String createToken(String username) {
        try {
            Date expiredDate = new Date(new Date().getTime() + expirationTime);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(issuer).withExpiresAt(expiredDate)
                    .withClaim("username", username)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            return null;
        }
    }

    public String decodeToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("username").asString();
        } catch (JWTVerificationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("Invalid token");
        }
    }
}
