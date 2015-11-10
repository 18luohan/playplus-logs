/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.domain;

import com.beautysight.common.bizapp.utils.PreconditionUtils;
import com.beautysight.common.mongobased.domain.MongoAwareEntity;
import com.google.common.base.Optional;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;
import java.util.HashMap;

/**
 * @author chenlong
 * @since 1.0
 */
@Entity(value = "user_logs", noClassnameStored = true)
public class UserLog extends MongoAwareEntity {

    private String sessionId;
    private Integer code;
    private Date createdAt = new Date();
    private Payload payload;
    private User user;
    private Client client;
    private GeoLocation loc;

    public static class Payload extends HashMap<String, Object> {
        private static final String COUNT_KEY = "count";
        private static final String SRC_PAGE_NO_KEY = "srcPageNo";
        private static final String DURATION_KEY = "duration";
    }

    public void validate() {
        PreconditionUtils.checkRequired("sessionId", sessionId);
        PreconditionUtils.checkRequired("code", code);

        if (user != null) {
            user.validate(Optional.of("user"));
        }

        PreconditionUtils.checkRequired("client", client);
        client.validate(Optional.of("client"));

        if (loc != null) {
            loc.validate(Optional.of("loc"));
        }
    }

}