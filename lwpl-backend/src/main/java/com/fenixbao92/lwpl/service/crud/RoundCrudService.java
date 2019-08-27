package com.fenixbao92.lwpl.service.crud;

import com.fenixbao92.lwpl.common.model.Round;
import com.fenixbao92.lwpl.common.vo.RoundVo;
import com.fenixbao92.lwpl.dao.RoundMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoundCrudService {

    @Resource
    private RoundMapper roundMapper;


    public int insert(Round round){
        return roundMapper.insert(round);
    }


    public int insertSelective(Round round){
        return roundMapper.insertSelective(round);
    }


    public int insertList(List<Round> rounds){
        return roundMapper.insertList(rounds);
    }


    public int updateByPrimaryKeySelective(Round round){
        return roundMapper.updateByPrimaryKeySelective(round);
    }

    public List<Round> findByAll(RoundVo roundVo){
        return roundMapper.findByAll(roundVo);
    }

    public Long findCntByAll(RoundVo roundVo){
        return roundMapper.findCntByAll(roundVo);
    }

    public int deleteByRoundId(Long roundId){
        return roundMapper.deleteByRoundId(roundId);
    }
}
