package com.fenixbao92.lwpl.service.crud;

import com.fenixbao92.lwpl.common.model.Give;
import com.fenixbao92.lwpl.common.vo.GiveVo;
import com.fenixbao92.lwpl.dao.GiveMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GiveCrudService {

    @Resource
    private GiveMapper giveMapper;


    public int insert(Give give){
        return giveMapper.insert(give);
    }


    public int insertSelective(Give give){
        return giveMapper.insertSelective(give);
    }


    public int insertList(List<Give> gives){
        return giveMapper.insertList(gives);
    }


    public int updateByPrimaryKeySelective(Give give){
        return giveMapper.updateByPrimaryKeySelective(give);
    }

    public List<Give> findByAll(GiveVo giveVo){
        return giveMapper.findByAll(giveVo);
    }

    public Long findCntByAll(GiveVo giveVo){
        return giveMapper.findCntByAll(giveVo);
    }

    public int deleteByGiveId(Long giveId){
        return giveMapper.deleteByGiveId(giveId);
    }
}
