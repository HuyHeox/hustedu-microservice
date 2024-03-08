package com.hn.userservice.repository.impl;

import com.hn.userservice.model.User;
import com.hn.userservice.repository.UserRepository;
import com.hn.userservice.repository.generic.AbstractRepositoryImpl;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang.StringUtils;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl(MongoDatabase db) {
        super(db, "User", User.class, Long.class);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            return Optional.empty();
        }
        Bson filter = (Bson) BasicDBObjectBuilder.start("username", username).get();
        return Optional.ofNullable(getCollection().find(filter).first());
    }
}
