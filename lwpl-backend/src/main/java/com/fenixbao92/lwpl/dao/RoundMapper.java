package com.fenixbao92.lwpl.dao;

import com.fenixbao92.lwpl.common.vo.RoundVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.fenixbao92.lwpl.common.model.Round;

@Mapper
public interface RoundMapper {
    int insert(@Param("round") Round round);

    int insertSelective(@Param("round") Round round);

    int insertList(@Param("rounds") List<Round> rounds);

    int updateByPrimaryKeySelective(@Param("round") Round round);

    List<Round> findByAll(RoundVo roundVo);

    Long findCntByAll(RoundVo roundVo);

    int deleteByRoundId(@Param("roundId")Long roundId);

}
