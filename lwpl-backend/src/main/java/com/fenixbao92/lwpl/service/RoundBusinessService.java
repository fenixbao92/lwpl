package com.fenixbao92.lwpl.service;

import com.fenixbao92.lwpl.common.model.Round;
import com.fenixbao92.lwpl.common.utils.VoConverter;
import com.fenixbao92.lwpl.common.vo.RoundVo;
import com.fenixbao92.lwpl.service.crud.RoundCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoundBusinessService {

    @Resource
    private RoundCrudService roundCrudService;

    public List<RoundVo> getList(RoundVo roundVo) {
        List<Round> list = roundCrudService.findByAll(roundVo);
        return list.stream().map(VoConverter::forRound).collect(Collectors.toList());
    }

    public Long getCount(RoundVo roundVo) {
        return roundCrudService.findCntByAll(roundVo);
    }

    public void add(Round round) {
        roundCrudService.insertSelective(round);
    }

    public void deleteById(Long roundId) {
        roundCrudService.deleteByRoundId(roundId);
    }

    public void updateRound(Round round) {
        roundCrudService.updateByPrimaryKeySelective(round);
    }

}