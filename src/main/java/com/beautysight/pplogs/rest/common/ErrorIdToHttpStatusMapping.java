/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.rest.common;

import com.beautysight.common.ex.CommonErrorId;
import com.beautysight.common.ex.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenlong
 * @since 1.0
 */
public class ErrorIdToHttpStatusMapping {

    private static final Logger logger = LoggerFactory.getLogger(ErrorIdToHttpStatusMapping.class);

    private static final Map<Error.Id, HttpStatus> MAPPING = new HashMap<>();

    static {

        // 5xx Server Error
        MAPPING.put(CommonErrorId.internal_server_error, HttpStatus.INTERNAL_SERVER_ERROR);
        MAPPING.put(CommonErrorId.service_unavailable, HttpStatus.SERVICE_UNAVAILABLE);

        // 4xx Client Error
        MAPPING.put(CommonErrorId.invalid_params, HttpStatus.UNPROCESSABLE_ENTITY);
        MAPPING.put(CommonErrorId.illegal_app_id, HttpStatus.UNAUTHORIZED);
    }

    public static HttpStatus correspondingStatus(Error.Id errorId) {
        HttpStatus status = MAPPING.get(errorId);
        if (status == null) {
            logger.error("No corresponding http status to error id: {}", errorId);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return status;
    }

}
