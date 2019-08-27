package com.fenixbao92.lwpl.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {

    private Long userId;

    private String openId;
    private String nickName;
    private Integer gender;
    private String country;
    private String province;
    private String city;
    private String avatarUrl;
    private String language;

    private String unionId;
    private String sessionKey;
    private Date lastLoginTime;
    private Date updateTime;

    private Long inviteUserId;
}
