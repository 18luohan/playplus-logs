/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.rest.common;


import com.google.common.base.Optional;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author chenlong
 * @since 1.0
 */
public class Requests {

    public static final String APP_ID_HEADER = "X-BeautySight-App-ID";

    public static String methodAndURI(HttpServletRequest request) {
        return String.format("%s %s", request.getMethod(), request.getRequestURI());
    }

    public static Optional<String> appIdOf(HttpServletRequest request) {
        return Requests.getHeader(APP_ID_HEADER, request);
    }

    public static Optional<String> getHeader(String headerName, HttpServletRequest request) {
        String val = request.getHeader(headerName);
        return Optional.fromNullable(
                decodeWithUTF8(val, String.format("request header %s", headerName)));
    }

    public static String decodeWithUTF8(String data, String dataDescription) {
        if (StringUtils.isBlank(data)) {
            return null;
        }

        try {
            return URLDecoder.decode(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(String.format("Decode %s with UTF-8", dataDescription), e);
        }
    }

}
