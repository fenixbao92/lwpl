package com.fenixbao92.lwpl.common.constants;

import lombok.Getter;

@Getter
public enum BusinessExceptionEnum {

    DEFAULT_ERROR("default error",600),
    DATABASE_ERROR("database error",601),

    WEB_NEED_LOGIN("web need log",701),

    WX_SESSION_INVALID("wx session invalid", 801),
    ;

    private String description;
    private int code;

    BusinessExceptionEnum(String description, int code) {
        this.description = description;
        this.code = code;
    }

}
