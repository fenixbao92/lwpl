package com.fenixbao92.lwpl.common.exceptions;

import com.fenixbao92.lwpl.common.constants.BusinessExceptionEnum;
import lombok.Getter;
import lombok.Setter;


/**
 * Create by fenixbao92 on 2019/5/13.
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private int code;   // 异常状态码
    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        super(businessExceptionEnum.getDescription());
        code = businessExceptionEnum.getCode();
    }
    public BusinessException(String description) {
        super(description);
        code = BusinessExceptionEnum.DEFAULT_ERROR.getCode();
    }
    public int getCode() {
        return code;
    }
}
