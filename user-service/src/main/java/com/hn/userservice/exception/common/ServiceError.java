package com.hn.userservice.exception.common;

import lombok.Getter;

@Getter
public enum ServiceError {
    CMN_ACCESS_DENIED(401, "err.authorize.access-denied"),
    CMN_INVALID_PARAM(400, "err.api.invalid-param"),
    CMN_HTTP_METHOD_NOT_SUPPORT(405, "err.api.http-method-not-support"),
    CMN_MEDIA_TYPE_NOT_SUPPORT(415, "err.api.media-type-not-support"),
    CMN_MESSAGE_NOT_READABLE(400, "err.api.message-not-readable"),

    USER_NOT_FOUND(401, "err.api.user-not-found"),
    UNEXPECTED_EXCEPTION(500, "err.sys.unexpected-exception"),

    USER_ALREADY_EXIST(409, "err.sys.username-already-exist");
    ServiceError(int errCode, String messageKey) {
        this.errCode = errCode;
        this.messageKey = messageKey;
    }

    private final int errCode;
    private final String messageKey;
}
