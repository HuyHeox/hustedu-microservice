package com.hn.userservice.repository.generic;

import com.mongodb.client.MongoCollection;

public interface AbstractRepository<T, H> {
    MongoCollection<T> getCollection();
}
