package com.hn.userservice.grpcservice;

import com.google.protobuf.Empty;
import com.hn.User;
import com.hn.UserServiceGrpc;
import com.hn.userservice.service.UserService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class UserGrpcServerService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    UserService userService;
    @Override
    public void getUser(User request, StreamObserver<User> responseObserver) {
//        User user = userService.getUserByUsername(request.getUsername());
        User user = User.newBuilder().setUsername("huy.nq").setFullName("ngo quang huy").build();
        responseObserver.onNext(user);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllUser(Empty request, StreamObserver<User> responseObserver) {
        User user = User.newBuilder().setUsername("huy.nq").setFullName("ngo quang huy").build();
        User user1 = User.newBuilder().setUsername("huy.nq1").setFullName("ngo quang huy1").build();
        responseObserver.onNext(user);
        responseObserver.onNext(user1);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<User> getShortestNameUser(StreamObserver<User> responseObserver) {
        return new StreamObserver<User>(){
            User shortestNameUser = null;
            int shortestNameLengh = 1000 ;
            @Override
            public void onNext(User user) {
                if (user.getFullName().length() < shortestNameLengh){
                    shortestNameUser = user;
                    shortestNameLengh = user.getFullName().length();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(shortestNameUser);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<User> updateUsernameByFullName(StreamObserver<User> responseObserver) {
        return new StreamObserver<User>(){
            List<User> listUser = new ArrayList<>();
            @Override
            public void onNext(User user) {
                User newUser = User.newBuilder().setUsername(user.getFullName()).setFullName(user.getFullName()).build();
                listUser.add(newUser);
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                listUser.forEach(responseObserver::onNext);
                responseObserver.onCompleted();
            }
        };
    }
}
