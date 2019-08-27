package com.fenixbao92.lwpl.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Give {
    private Long giveId;
    private Long roundId;
    private Long fromPlayerId;
    private Long toPlayerId;
    private Integer unit;
}