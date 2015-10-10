/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.infrastructure.persistence.mongo.base;

import com.google.common.base.Preconditions;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author chenlong
 * @since 1.0
 */
public abstract class AbstractMongoRepository<T> implements MongoRepository<T> {

    @Autowired
    protected Datastore datastore;

    @Override
    public <S extends T> S save(S entity) {
        Assert.notNull(entity, "The given entity must not be null!");
        datastore.save(entity);
        return entity;
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        Assert.notNull(entities, "The given Iterable of entities not be null!");

        List<S> result = convertIterableToList(entities);
        for (S entity : result) {
            save(entity);
        }
        return result;
    }

    @Override
    public T findOne(ObjectId id) {
        Assert.notNull(id, "The given id must not be null!");
        return datastore.get(entityClass(), id);
    }

    @Override
    public boolean exists(ObjectId id) {
        Assert.notNull(id, "The given id must not be null!");
//        Key<?> key = datastore.exists(new Key<T>(entityClass(), id));
//        // TODO 需要确认这样判断是否存在靠不靠谱？
//        return (key != null);
        return false;
    }

    /**
     * Return all documents in a collection, so that could be costly with large result sets.
     *
     * @return
     */
    @Override
    public Iterable<T> findAll() {
        return datastore.find(entityClass()).asList();
    }

    @Override
    public Iterable<T> findAll(Iterable<ObjectId> ids) {
        if (isNullOrEmpty(ids)) {
            return Collections.emptyList();
        }
        return datastore.createQuery(entityClass()).field("id").in(ids).asList();
    }

    @Override
    public long count() {
        return datastore.getCount(entityClass());
    }

    @Override
    public void delete(ObjectId id) {
        Assert.notNull(id, "The given id must not be null!");
        WriteResult result = datastore.delete(entityClass(), id);
        checkWriteResult(Op.DELETE, result, 1);
    }

    /**
     * Deletes the given entity (by @Id)
     */
    @Override
    public void delete(T entity) {
        Assert.notNull(entity, "The given entity must not be null!");
        WriteResult result = datastore.delete(entity);
        checkWriteResult(Op.DELETE, result, 1);
    }

    /**
     * Deletes the given entities (by @Id)
     *
     * @param entities
     */
    @Override
    public void delete(Iterable<? extends T> entities) {
        Preconditions.checkArgument(!isNullOrEmpty(entities), "The given entities must not be null or empty!");

        for (T entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        datastore.delete(datastore.createQuery(entityClass()));
    }

    protected abstract Class<T> entityClass();

    protected void checkWriteResult(Op op, WriteResult result, int expected) {
        if (result.getN() != expected) {
            throw new IncorrectOperationResultException(
                    String.format("%s: expected %s, actual %s", op, expected, result.getN()));
        }
    }

    private static boolean isNullOrEmpty(Iterable<?> iterable) {
        if (iterable == null) {
            return true;
        }

        if (iterable instanceof Collection) {
            return CollectionUtils.isEmpty((Collection<?>) iterable);
        }

        return false;
    }

    private static <T> List<T> convertIterableToList(Iterable<T> entities) {
        if (entities instanceof List) {
            return (List<T>) entities;
        }

        int capacity = tryDetermineRealSizeOrReturn(entities, 10);
        if (capacity == 0 || entities == null) {
            return Collections.emptyList();
        }

        List<T> list = new ArrayList<T>(capacity);
        for (T entity : entities) {
            list.add(entity);
        }

        return list;
    }

    private static int tryDetermineRealSizeOrReturn(Iterable<?> iterable, int defaultSize) {
        return iterable == null ? 0 : (iterable instanceof Collection) ? ((Collection<?>) iterable).size() : defaultSize;
    }

    protected enum Op {
        DELETE, UPDATE
    }

}
