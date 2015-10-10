/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.app;

import com.beautysight.pplogs.domain.UserLog;
import com.beautysight.pplogs.domain.UserLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenlong
 * @since 1.0
 */
@Service
public class UserLogApp {

    @Autowired
    private UserLogRepo userLogRepo;

    public void writeUserLog(UserLog userLog) {
        userLogRepo.save(userLog);
    }

}
