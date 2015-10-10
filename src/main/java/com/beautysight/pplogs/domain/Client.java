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
public class Client extends DomainVO {

    private String imei;
    private String imsi;
    private String appVersion;
    private OS os;
    private String model;

    public static class OS extends DomainVO {
        private Type type;
        private String version;
        // Android系统的各种分发版
        private String distribution;

        public void validate() {
            PreconditionUtils.checkRequired("client.os.type", type);
            PreconditionUtils.checkRequired("client.os.version", version);
            PreconditionUtils.checkRequired("client.os.distribution", distribution);
        }

        public enum Type {
            android, ios
        }
    }

    public void validate() {
        PreconditionUtils.checkRequired("client.imei", imei);
        PreconditionUtils.checkRequired("client.imsi", imsi);
        PreconditionUtils.checkRequired("client.appVersion", appVersion);
        PreconditionUtils.checkRequired("client.os", os);
        os.validate();
    }

}