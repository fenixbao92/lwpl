package com.fenixbao92.lwpl.service;

import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.utils.BeanMapper;
import com.fenixbao92.lwpl.common.utils.VoConverter;
import com.fenixbao92.lwpl.common.vo.UserVo;
import com.fenixbao92.lwpl.service.crud.UserCrudService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserBusinessService {

    @Resource
    private UserCrudService userCrudService;

    public List<UserVo> getList(UserVo userVo) {
        List<User> list = userCrudService.findByAll(userVo);
        return list.stream().map(VoConverter::forUser).collect(Collectors.toList());
    }

    public Long getCount(UserVo userVo) {
        return userCrudService.findCntByAll(userVo);
    }

    public void add(User user) {
        userCrudService.insertSelective(user);
    }

    public void deleteById(Long userId) {
        userCrudService.deleteByUserId(userId);
    }

    public void updateUser(User user) {
        userCrudService.updateByPrimaryKeySelective(user);
    }

    /////////////
    public void push(UserVo userVo) {
        List<User> list = userCrudService.findByAll(userVo);
        if(!CollectionUtils.isEmpty(list)){
            Long userId = list.get(0).getUserId();
            User newUser = new User();
            BeanMapper.copy(userVo,newUser);
            newUser.setUserId(userId);
            updateUser(newUser);
        }else {
            User newUser = new User();
            BeanMapper.copy(userVo,newUser);
            add(newUser);
        }
    }

}