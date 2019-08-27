package com.fenixbao92.lwpl.dao;

import com.fenixbao92.lwpl.common.vo.GiveVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.fenixbao92.lwpl.common.model.Give;

@Mapper
public interface GiveMapper {
    int insert(@Param("give") Give give);

    int insertSelective(@Param("give") Give give);

    int insertList(@Param("gives") List<Give> gives);

    int updateByPrimaryKeySelective(@Param("give") Give give);

    List<Give> findByAll(GiveVo giveVo);

    Long findCntByAll(GiveVo giveVo);

    int deleteByGiveId(@Param("giveId")Long giveId);

}
