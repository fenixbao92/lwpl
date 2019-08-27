package com.fenixbao92.lwpl.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Round {
    private Long roundId;
    private Long playId;
    private Integer finishCnt;
}