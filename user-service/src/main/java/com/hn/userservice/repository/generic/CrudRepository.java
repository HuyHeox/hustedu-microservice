package com.hn.userservice.repository.generic;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Objects;

public interface CrudRepository<T, H> extends ReadOnlyRepository<T, H> {

    default List<T> saveAll(List<T> entities) {
        getCollection().insertMany(entities);
        return entities;
    }

    default T save(T entity) {
        if (Objects.isNull(entity)) {
            throw new NullPointerException("entity is null");
        }
        getCollection().insertOne(entity);
        return entity;
    }

    default T replace(H id, T entity) {
        if (Objects.isNull(id)) {
            throw new NullPointerException("id is null");
        }
        if (Objects.isNull(entity)) {
            throw new NullPointerException("entity is null");
        }
        Bson filter = (Bson) BasicDBObjectBuilder.start("_id", id).get();
        ReplaceOptions replaceOptions = new ReplaceOptions().upsert(false);
        getCollection().replaceOne(filter, entity, replaceOptions);
        return entity;
    }

    default T upsert(H id, T entity) {
        if (Objects.isNull(id)) {
            throw new NullPointerException("id is null");
        }
        if (Objects.isNull(entity)) {
            throw new NullPointerException("entity is null");
        }
        Bson filter = (Bson) BasicDBObjectBuilder.start("_id", id).get();
        ReplaceOptions replaceOptions = new ReplaceOptions().upsert(true);
        getCollection().replaceOne(filter, entity, replaceOptions);
        return entity;
    }

    default void delete(H id) {
        if (Objects.isNull(id)) {
            throw new NullPointerException("id is null");
        }
        Bson filter = (Bson) BasicDBObjectBuilder.start("_id", id).get();
        getCollection().deleteOne(filter);
    }
}
