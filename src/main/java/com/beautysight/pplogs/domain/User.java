/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.domain;


import com.beautysight.common.bizapp.domain.ValueObject;
import com.beautysight.common.bizapp.utils.PreconditionUtils;
import com.google.common.base.Optional;

/**
 * @author chenlong
 * @since 1.0
 */
public class User extends ValueObject {

    private String id;
    private String globalId;
    private String nickname;

    @Override
    public void validate(Optional<String> fieldPrefix) {
        PreconditionUtils.checkRequired(prefixTo("id", fieldPrefix), id);
        PreconditionUtils.checkRequired(prefixTo("globalId", fieldPrefix), globalId);
    }

}