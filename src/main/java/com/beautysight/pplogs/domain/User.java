/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.domain;

import com.beautysight.common.domain.DomainVO;
import com.beautysight.common.utils.PreconditionUtils;

/**
 * @author chenlong
 * @since 1.0
 */
public class User extends DomainVO {

    private String id;
    private String globalId;
    private String nickname;

    public void validate() {
        PreconditionUtils.checkRequired("user.id", id);
        PreconditionUtils.checkRequired("user.globalId", globalId);
    }

}