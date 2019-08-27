package com.fenixbao92.lwpl.dao;
import java.util.Date;

import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(@Param("user") User user);

    int insertSelective(@Param("user") User user);

    int insertList(@Param("users") List<User> users);

    int updateByPrimaryKeySelective(@Param("user") User user);

    List<User> findByAll(UserVo userVo);

    Long findCntByAll(UserVo userVo);

    int deleteByUserId(@Param("userId")Long userId);


}
