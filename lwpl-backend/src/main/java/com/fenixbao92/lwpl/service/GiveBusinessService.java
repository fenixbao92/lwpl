package com.fenixbao92.lwpl.service;

import com.fenixbao92.lwpl.common.model.Give;
import com.fenixbao92.lwpl.common.utils.VoConverter;
import com.fenixbao92.lwpl.common.vo.GiveVo;
import com.fenixbao92.lwpl.service.crud.GiveCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GiveBusinessService {

    @Resource
    private GiveCrudService giveCrudService;

    public List<GiveVo> getList(GiveVo giveVo) {
        List<Give> list = giveCrudService.findByAll(giveVo);
        return list.stream().map(VoConverter::forGive).collect(Collectors.toList());
    }

    public Long getCount(GiveVo giveVo) {
        return giveCrudService.findCntByAll(giveVo);
    }

    public void add(Give give) {
        giveCrudService.insertSelective(give);
    }

    public void deleteById(Long giveId) {
        giveCrudService.deleteByGiveId(giveId);
    }

    public void updateGive(Give give) {
        giveCrudService.updateByPrimaryKeySelective(give);
    }

}