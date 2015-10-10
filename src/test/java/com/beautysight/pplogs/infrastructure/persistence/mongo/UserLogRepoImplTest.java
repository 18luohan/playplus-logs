/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.infrastructure.persistence.mongo;

import com.beautysight.common.utils.Jsons;
import com.beautysight.pplogs.domain.UserLog;
import com.beautysight.pplogs.domain.UserLogRepo;
import com.beautysight.SpringBasedAppTest;
import com.beautysight.utils.Files;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * @author chenlong
 * @since 1.0
 */
public class UserLogRepoImplTest extends SpringBasedAppTest {

    @Autowired
    private UserLogRepo userLogRepo;

    @Test
    public void writeLog() {
        File jsonFile = Files.fileInSameDirWith(UserLogRepoImplTest.class, "user_log.json");
        UserLog logEntry = Jsons.toObject(jsonFile, UserLog.class);
        userLogRepo.save(logEntry);
    }

}