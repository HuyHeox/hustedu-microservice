package com.hn.userservice.exception;

import com.hn.userservice.exception.common.BusinessException;
import com.hn.userservice.exception.common.ServiceError;

public class UsernameAlreadyExistException extends BusinessException {
    public UsernameAlreadyExistException(String userName) {
        super(ServiceError.USER_ALREADY_EXIST, null, buildSingleParamMaps("userName", userName));
    }
}
