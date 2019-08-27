package com.fenixbao92.lwpl.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Play {
    private Long playId;
    private Integer playerCnt;
    private Integer code;
    private Integer unitPrice;
    private Integer status;
}
