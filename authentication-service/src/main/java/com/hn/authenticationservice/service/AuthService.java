package com.hn.authenticationservice.service;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Empty;
import com.hn.User;
import com.hn.UserServiceGrpc;
import com.hn.authenticationservice.dto.UserResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    JwtService jwtService;
    private final WebClient.Builder webClientBuilder;

    @GrpcClient("grpc-hn-service")
    UserServiceGrpc.UserServiceBlockingStub synchronousClient;
    @GrpcClient("grpc-hn-service")
    UserServiceGrpc.UserServiceStub asynchronousClient;

    public UserResponse getUserByUsername(String username) {
        return webClientBuilder.build().get()
                .uri("http://user-service/api/user/",
                        uriBuilder -> uriBuilder.queryParam("username", username).build())
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
    }

    public Map<Descriptors.FieldDescriptor, Object> getUserByUsernameGrpc(String username) {
        User user = User.newBuilder().setUsername(username).build();
        User userResponse = synchronousClient.getUser(user);
        return userResponse.getAllFields();
    }
    public List<Map<Descriptors.FieldDescriptor, Object>> getAllUserGrpc() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();

        asynchronousClient.getAllUser(Empty.getDefaultInstance(), new StreamObserver<User>() {
            @Override
            public void onNext(User user) {
                response.add(user.getAllFields());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyList();
    }

    public Map<String,Map<Descriptors.FieldDescriptor, Object>> getShortestName() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Map<String,Map<Descriptors.FieldDescriptor, Object>> response = new HashMap<>();
        StreamObserver<User> responseObserver = asynchronousClient.getShortestNameUser(new StreamObserver<User>() {
            @Override
            public void onNext(User user) {
                response.put("shortestName" , user.getAllFields());
                countDownLatch.countDown();
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        User user1 = User.newBuilder().setFullName("12312").build();
        User user2 = User.newBuilder().setFullName("huy ngo quang").build();
        responseObserver.onNext(user1);
        responseObserver.onNext(user2);
        responseObserver.onCompleted();
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyMap();
    }

    public List<Map<Descriptors.FieldDescriptor, Object>> updateUsernameByFullName() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();
        StreamObserver<User> responseObserver = asynchronousClient.updateUsernameByFullName(new StreamObserver<User>() {
            @Override
            public void onNext(User user) {
                response.add(user.getAllFields());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        User user1 = User.newBuilder().setFullName("12312").build();
        User user2 = User.newBuilder().setFullName("huy ngo quang").build();
        responseObserver.onNext(user1);
        responseObserver.onNext(user2);
        responseObserver.onCompleted();
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyList();
    }

    public String generateToken(String username){
        return jwtService.createToken(username);
    }

    public String validateToken(String token){
        return jwtService.decodeToken(token);
    }
}
