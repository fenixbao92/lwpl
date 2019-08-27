package com.fenixbao92.lwpl.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GiveVo {
    private Long giveId;
    private Long roundId;
    private Long fromPlayerId;
    private Long toPlayerId;
    private Integer unit;

    private Long offset;
    private Integer limit;
}
