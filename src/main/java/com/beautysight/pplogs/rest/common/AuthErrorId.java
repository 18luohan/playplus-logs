/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.rest.common;

import com.beautysight.common.bizapp.ex.Error;

/**
 * @author chenlong
 * @since 1.0
 */
public enum AuthErrorId implements Error.Id {

    illegal_app_client(10101);

    private Integer code;

    AuthErrorId(Integer code) {
        this.code = code;
    }

    @Override
    public String get() {
        return this.toString();
    }

    @Override
    public Integer code() {
        return this.code;
    }

}
