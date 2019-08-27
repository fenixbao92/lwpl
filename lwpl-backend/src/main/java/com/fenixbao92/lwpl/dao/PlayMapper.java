package com.fenixbao92.lwpl.dao;

import com.fenixbao92.lwpl.common.vo.PlayVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.fenixbao92.lwpl.common.model.Play;

@Mapper
public interface PlayMapper {
    int insert(@Param("play") Play play);

    int insertSelective(@Param("play") Play play);

    int insertList(@Param("plays") List<Play> plays);

    int updateByPrimaryKeySelective(@Param("play") Play play);

    List<Play> findByAll(PlayVo playVo);

    Long findCntByAll(PlayVo playVo);

    int deleteByPlayId(@Param("playId")Long playId);

}
