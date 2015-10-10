/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.infrastructure.persistence.mongo.base;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * @author chenlong
 * @since 1.0
 */
public interface MongoRepository<T> extends CrudRepository<T, ObjectId> {
}
