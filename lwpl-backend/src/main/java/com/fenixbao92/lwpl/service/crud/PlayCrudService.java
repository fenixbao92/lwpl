package com.fenixbao92.lwpl.service.crud;

import com.fenixbao92.lwpl.common.model.Play;
import com.fenixbao92.lwpl.common.vo.PlayVo;
import com.fenixbao92.lwpl.dao.PlayMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlayCrudService {

    @Resource
    private PlayMapper playMapper;


    public int insert(Play play){
        return playMapper.insert(play);
    }


    public int insertSelective(Play play){
        return playMapper.insertSelective(play);
    }


    public int insertList(List<Play> plays){
        return playMapper.insertList(plays);
    }


    public int updateByPrimaryKeySelective(Play play){
        return playMapper.updateByPrimaryKeySelective(play);
    }

    public List<Play> findByAll(PlayVo playVo){
        return playMapper.findByAll(playVo);
    }

    public Long findCntByAll(PlayVo playVo){
        return playMapper.findCntByAll(playVo);
    }

    public int deleteByPlayId(Long playId){
        return playMapper.deleteByPlayId(playId);
    }
}
