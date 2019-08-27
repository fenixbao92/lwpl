package com.fenixbao92.lwpl.service;

import com.fenixbao92.lwpl.common.model.Play;
import com.fenixbao92.lwpl.common.utils.VoConverter;
import com.fenixbao92.lwpl.common.vo.PlayVo;
import com.fenixbao92.lwpl.service.crud.PlayCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlayBusinessService {

    @Resource
    private PlayCrudService playCrudService;

    public List<PlayVo> getList(PlayVo playVo) {
        List<Play> list = playCrudService.findByAll(playVo);
        return list.stream().map(VoConverter::forPlay).collect(Collectors.toList());
    }

    public Long getCount(PlayVo playVo) {
        return playCrudService.findCntByAll(playVo);
    }

    public void add(Play play) {
        playCrudService.insertSelective(play);
    }

    public void deleteById(Long playId) {
        playCrudService.deleteByPlayId(playId);
    }

    public void updatePlay(Play play) {
        playCrudService.updateByPrimaryKeySelective(play);
    }

}