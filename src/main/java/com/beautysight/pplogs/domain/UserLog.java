/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.domain;

import com.beautysight.common.domain.DomainEntity;
import com.beautysight.common.domain.DomainVO;
import com.beautysight.common.utils.PreconditionUtils;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * @author chenlong
 * @since 1.0
 */
@Entity(value = "user_logs", noClassnameStored = true)
public class UserLog extends DomainEntity {

    private String sessionId;
    private Integer code;
    private Date createdAt = new Date();
    private Payload payload;
    private User user;
    private Client client;
    private GeoLocation loc;

    public static class Payload extends DomainVO {
        private Integer count;
        private String srcPageNo;
        private Integer duration;
    }

    public void validate() {
        PreconditionUtils.checkRequired("sessionId", sessionId);
        PreconditionUtils.checkRequired("code", code);

        if (user != null) {
            user.validate();
        }

        PreconditionUtils.checkRequired("client", client);
        client.validate();

        if (loc != null) {
            loc.validate();
        }
    }

}