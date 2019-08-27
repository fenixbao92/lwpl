package com.fenixbao92.lwpl.controller;

import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.vo.UserVo;
import com.fenixbao92.lwpl.config.redis.RedisTool;
import com.fenixbao92.lwpl.service.UserBusinessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserBusinessService userBusinessService;

    @Resource
    RedisTool redisTool;
    @RequestMapping(value = "/page")
    public Map<String, Object> getPage(UserVo userVo) {
        List<UserVo> userVoList = userBusinessService.getList(userVo);
        Long count = userBusinessService.getCount(userVo);
        Map<String, Object> map = new HashMap<>();
        map.put("users", userVoList);
        map.put("count", count);
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add(User user) {
        redisTool.setex("ddds",23111,"sdsd");
        System.out.println("ddddd");
        userBusinessService.add(user);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam Long userId) {
        userBusinessService.deleteById(userId);
    }

    @RequestMapping("/update")
    public void update(User user) {
        userBusinessService.updateUser(user);
    }

    @RequestMapping(value = "/setRedis", method = RequestMethod.GET)
    public void testRedis(String value) {
        redisTool.setex("value",9999,value);
    }

    @RequestMapping(value = "/getRedis", method = RequestMethod.GET)
    public String testRedis() {
        return redisTool.get("value");
    }
}