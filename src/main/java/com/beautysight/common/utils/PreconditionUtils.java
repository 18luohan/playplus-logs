/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.common.utils;

/**
 * @author chenlong
 * @since 1.0
 */

import com.beautysight.common.ex.IllegalParamException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author chenlong
 * @since 1.0
 */
public class PreconditionUtils {

    public static void checkRequired(String field, String val) {
        if (StringUtils.isBlank(val)) {
            throw new IllegalParamException("%s required", field);
        }
    }

    public static void checkRequired(String field, Collection<?> val) {
        if (CollectionUtils.isEmpty(val)) {
            throw new IllegalParamException("collection %s must not be null or empty", field);
        }
    }

    public static void checkRequired(String field, Object val) {
        if (val == null) {
            throw new IllegalParamException("%s required", field);
        }
    }

    public static void checkGreaterThanZero(String field, Integer val) {
        checkGreaterThan(0, field, val);
    }

    public static void checkGreaterThan(int bound, String field, Integer val) {
        checkRequired(field, val);
        if (val <= bound) {
            throw new IllegalParamException("%s must be greater than %s, actual %s", field, bound, val);
        }
    }

    public static void checkGreaterThanOrEqZero(String field, Integer val) {
        checkGreaterThanOrEq(0, field, val);
    }

    public static void checkGreaterThanOrEq(int bound, String field, Integer val) {
        checkRequired(field, val);
        if (val < bound) {
            throw new IllegalParamException("%s must be greater than or eq %s, actual %s", field, bound, val);
        }
    }

    public static <T> void checkEqual(T expected, T actual, String failedMessage) {
        if (expected != actual && !expected.equals(actual)) {
            throw new IllegalParamException(String.format("%s, expected %s, but actual %s",
                    failedMessage, expected, actual));
        }
    }

    public static void between(Float smallerBound, Float biggerBound, String field, Float val) {
        checkRequired(field, val);
        if (val < smallerBound || val > biggerBound) {
            throw new IllegalParamException(String.format("%s must be between %s(include) and %s(include), but actual %s",
                    field, smallerBound, biggerBound, val));
        }
    }

}
