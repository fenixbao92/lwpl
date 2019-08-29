package com.fenixbao92.lwpl.controller;

import com.fenixbao92.lwpl.common.model.Play;
import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.vo.PlayVo;
import com.fenixbao92.lwpl.common.vo.UserVo;
import com.fenixbao92.lwpl.config.redis.RedisTool;
import com.fenixbao92.lwpl.service.PlayBusinessService;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/play")
@Slf4j
public class PlayController {

    @Resource
    private PlayBusinessService playBusinessService;

    @RequestMapping(value = "/page")
    public Map<String, Object> getPage(PlayVo playVo) {
        List<PlayVo> playVoList = playBusinessService.getList(playVo);
        Long count = playBusinessService.getCount(playVo);
        Map<String, Object> map = new HashMap<>();
        map.put("plays", playVoList);
        map.put("count", count);
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add(Play play) {
        playBusinessService.add(play);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam Long playId) {
        playBusinessService.deleteById(playId);
    }

    @RequestMapping("/update")
    public void update(Play play) {
        playBusinessService.updatePlay(play);
    }


    //////////////
    @RequestMapping(value = "/create")
    public Integer create(PlayVo playVo,UserVo userVo) {
        //openid
        log.info(Joiner.on(":").join("[/play/create]", playVo,"|","userVo"));
        Integer code = playBusinessService.create(playVo,userVo);
        return code;
    }

    @RequestMapping(value = "/join")
    public Long join(PlayVo playVo, UserVo userVo) {
        log.info(Joiner.on(":").join("[/play/join]", playVo,"|","userVo"));
        Long playId = playBusinessService.join(playVo,userVo);
        return playId;
    }

    @RequestMapping(value = "/userList")
    public List<UserVo> getUserList(PlayVo playVo) {
        log.info(Joiner.on(":").join("[/play/getUserList]", playVo,"|","userVo"));
        List<UserVo> users = playBusinessService.getUserList(playVo);
        return users;
    }
}