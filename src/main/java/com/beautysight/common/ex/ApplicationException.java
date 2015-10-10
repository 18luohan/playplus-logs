/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.common.ex;

/**
 * @author chenlong
 * @since 1.0
 */
public class ApplicationException extends RuntimeException {

    private Error.Id errorId;

    public ApplicationException(String message) {
        super(message);
        this.errorId = CommonErrorId.internal_server_error;
    }

    public ApplicationException(String msgFormat, Object... msgArgs) {
        this(String.format(msgFormat, msgArgs));
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        this.errorId = CommonErrorId.internal_server_error;
    }

    public ApplicationException(Error.Id errorId, String message) {
        super(message);
        this.errorId = errorId;
    }

    public ApplicationException(Error.Id errorId, String msgFormat, Object... msgArgs) {
        this(errorId, String.format(msgFormat, msgArgs));
    }

    public ApplicationException(Error.Id errorId, String message, Throwable cause) {
        super(message, cause);
        this.errorId = errorId;
    }

    public ApplicationException(Error.Id errorId, Throwable cause, String msgFormat, Object... msgArgs) {
        this(errorId, String.format(msgFormat, msgArgs), cause);
    }

    public ApplicationException(Throwable cause, String msgFormat, Object... msgArgs) {
        this(String.format(msgFormat, msgArgs), cause);
    }

    public Error.Id errorId() {
        return errorId;
    }

}
