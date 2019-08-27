package com.fenixbao92.lwpl.common.utils;

import com.fenixbao92.lwpl.common.model.Give;
import com.fenixbao92.lwpl.common.model.Play;
import com.fenixbao92.lwpl.common.model.Round;
import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.vo.GiveVo;
import com.fenixbao92.lwpl.common.vo.PlayVo;
import com.fenixbao92.lwpl.common.vo.RoundVo;
import com.fenixbao92.lwpl.common.vo.UserVo;

public class VoConverter {

    public static UserVo forUser(User user){
        UserVo userVo = new UserVo();
        BeanMapper.copy(user,userVo);
        return userVo;
    }

    public static GiveVo forGive(Give give){
        GiveVo giveVo = new GiveVo();
        BeanMapper.copy(give,giveVo);
        return giveVo;
    }

    public static RoundVo forRound(Round round){
        RoundVo roundVo = new RoundVo();
        BeanMapper.copy(round,roundVo);
        return roundVo;
    }

    public static PlayVo forPlay(Play play){
        PlayVo playVo = new PlayVo();
        BeanMapper.copy(play,playVo);
        return playVo;
    }

}
