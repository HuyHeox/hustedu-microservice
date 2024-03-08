package com.hn.userservice.repository.generic;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class AbstractRepositoryImpl<T, H> implements AbstractRepository<T, H> {

    protected final Class<T> entityType;
    protected final Class<H> idType;
    protected final MongoDatabase db;
    protected final String collectionName;

    public AbstractRepositoryImpl(MongoDatabase db, String collectionName, Class<T> entityType, Class<H> idType) {
        this.db = db;
        this.collectionName = collectionName;
        this.entityType = entityType;
        this.idType = idType;
    }

    public MongoCollection<T> getCollection() {
        return db.getCollection(collectionName, entityType);
    }
}
