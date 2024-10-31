package com.lee.zipbob.global.exception.notfound;


import com.lee.zipbob.global.exception.BusinessException;
import com.lee.zipbob.global.exception.ErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public EntityNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
