/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.infrastructure.persistence.mongo;

import com.beautysight.pplogs.domain.UserLog;
import com.beautysight.pplogs.domain.UserLogRepo;
import com.beautysight.pplogs.infrastructure.persistence.mongo.base.AbstractMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenlong
 * @since 1.0
 */
@Repository
public class UserLogRepoImpl extends AbstractMongoRepository<UserLog> implements UserLogRepo {

    @Override
    protected Class<UserLog> entityClass() {
        return UserLog.class;
    }

}
