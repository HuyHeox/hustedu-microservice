package com.hn.api.security;

import com.hn.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    RouteValidator routeValidator;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    RestTemplate template;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        System.out.println("123123");
        return (((exchange, chain) -> {
            ServerHttpRequest newRequest = null;
            if (routeValidator.isSecured.test(exchange.getRequest())){
                //header contain token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw  new RuntimeException("Missing authorization header");
                }
                String authHeader = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")){
                    authHeader = authHeader.substring(7);
                }
                try {
//                    template.getForObject("http://AUTHENTICATION-SERVICE/validate?token"+authHeader, String.class);
                    newRequest = exchange.getRequest().mutate().header("loggedInUser",jwtUtil.decodeToken(authHeader)).build();
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    throw new RuntimeException("unauthorized");
                }
            }
            return chain.filter(exchange.mutate().request(Objects.requireNonNull(newRequest)).build());
        }));
    }

    public static class Config{

    }
    private final static String TOKEN_HEADER = "authorization";

}
