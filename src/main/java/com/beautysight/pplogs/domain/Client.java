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
public class Client extends ValueObject {

    private String imei;
    private String imsi;
    private String appVersion;
    private OS os;
    private String model;

    @Override
    public void validate(Optional<String> fieldPrefix) {
        PreconditionUtils.checkRequired(prefixTo("imei", fieldPrefix), imei);
        PreconditionUtils.checkRequired(prefixTo("imsi", fieldPrefix), imsi);
        PreconditionUtils.checkRequired(prefixTo("appVersion", fieldPrefix), appVersion);
        PreconditionUtils.checkRequired(prefixTo("os", fieldPrefix), os);

        os.validate(Optional.of(prefix(fieldPrefix) + "os"));
    }

    public static class OS extends ValueObject {
        private Type type;
        private String version;
        // Android系统的各种分发版
        private String distribution;

        @Override
        public void validate(Optional<String> fieldPrefix) {
            PreconditionUtils.checkRequired(prefixTo("type", fieldPrefix), type);
            PreconditionUtils.checkRequired(prefixTo("version", fieldPrefix), version);
            PreconditionUtils.checkRequired(prefixTo("distribution", fieldPrefix), distribution);
        }

        public enum Type {
            android, ios
        }
    }

}