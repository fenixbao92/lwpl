package com.fenixbao92.lwpl.service;

import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.utils.VoConverter;
import com.fenixbao92.lwpl.common.vo.UserVo;
import com.fenixbao92.lwpl.service.crud.UserCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

}