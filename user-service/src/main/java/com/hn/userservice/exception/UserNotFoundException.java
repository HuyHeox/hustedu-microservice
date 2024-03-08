package com.hn.userservice.exception;

import com.hn.userservice.exception.common.BusinessException;
import com.hn.userservice.exception.common.ServiceError;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(String userName) {
        super(ServiceError.USER_NOT_FOUND, null, buildSingleParamMaps("userName", userName));
    }
}
