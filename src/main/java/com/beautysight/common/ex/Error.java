/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.common.ex;

import com.beautysight.common.app.ViewModel;

/**
 * @author chenlong
 * @since 1.0
 */
public class Error implements ViewModel {

    private Id id;
    private Integer code;
    private String message;
    private String url;

    public Error() {
    }

    private Error(Error.Id errorId, String message) {
        this.id = errorId;
        this.code = errorId.code();
        this.message = message;
    }

    public static Error of(Error.Id errorId, String message) {
        return new Error(errorId, message);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public interface Id {
        String get();

        Integer code();
    }

}
