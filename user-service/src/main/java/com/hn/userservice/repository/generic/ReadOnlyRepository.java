package com.hn.userservice.repository.generic;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.springframework.util.CollectionUtils;

import java.util.*;

public interface ReadOnlyRepository<T, H> extends AbstractRepository<T, H> {

    default List<T> getAll() {
        List<T> entities = new ArrayList<>();
        getCollection().find().forEach(entities::add);
        return entities;
    }

    default Optional<T> getById(H id) {
        return Optional.ofNullable(id)
                .map(i -> getCollection().find((Bson) BasicDBObjectBuilder.start("_id", id).get()).first());
    }

    default List<T> getByIds(Collection<H> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        List<T> entities = new ArrayList<>();
        getCollection().find(Filters.in("_id", ids)).forEach(entities::add);
        return entities;
    }
}
