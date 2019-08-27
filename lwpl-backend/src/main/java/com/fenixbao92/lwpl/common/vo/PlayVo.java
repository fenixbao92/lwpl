package com.fenixbao92.lwpl.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayVo {
    private Long playId;
    private Integer playerCnt;
    private Integer code;
    private Integer unitPrice;
    private Integer status;

    private Long offset;
    private Integer limit;
}
