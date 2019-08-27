package com.fenixbao92.lwpl.service.crud;

import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.vo.UserVo;
import com.fenixbao92.lwpl.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCrudService {

    @Resource
    private UserMapper userMapper;

    
    public int insert(User user){
        return userMapper.insert(user);
    }

    
    public int insertSelective(User user){
        return userMapper.insertSelective(user);
    }

    
    public int insertList(List<User> users){
        return userMapper.insertList(users);
    }

    
    public int updateByPrimaryKeySelective(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> findByAll(UserVo userVo){
        return userMapper.findByAll(userVo);
    }

    public Long findCntByAll(UserVo userVo){
        return userMapper.findCntByAll(userVo);
    }

    public int deleteByUserId(Long userId){
        return userMapper.deleteByUserId(userId);
    }
}
