package com.fenixbao92.lwpl.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoundVo {
    private Long roundId;
    private Long playId;
    private Integer finishCnt;

    private Long offset;
    private Integer limit;
}