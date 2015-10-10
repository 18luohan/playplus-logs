/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.rest;

import com.beautysight.pplogs.app.UserLogApp;
import com.beautysight.pplogs.domain.UserLog;
import com.beautysight.pplogs.rest.common.APIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenlong
 * @since 1.0
 */
@RestController
@RequestMapping(APIs.LOGS_V1)
public class PlayplusLogsController {

    @Autowired
    private UserLogApp userLogApp;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void writeUserLog(@RequestBody UserLog userLog) {
        userLog.validate();
        userLogApp.writeUserLog(userLog);
    }

}
