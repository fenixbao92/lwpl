package com.fenixbao92.lwpl.service;

import com.fenixbao92.lwpl.common.exceptions.BusinessException;
import com.fenixbao92.lwpl.common.model.Play;
import com.fenixbao92.lwpl.common.model.User;
import com.fenixbao92.lwpl.common.utils.BeanMapper;
import com.fenixbao92.lwpl.common.utils.VoConverter;
import com.fenixbao92.lwpl.common.vo.PlayVo;
import com.fenixbao92.lwpl.common.vo.UserVo;
import com.fenixbao92.lwpl.service.crud.PlayCrudService;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlayBusinessService {

    @Resource
    private PlayCrudService playCrudService;

    @Resource
    private UserBusinessService userBusinessService;

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

    //////////
    public Integer create(PlayVo playVo,UserVo userVo) {
        log.info(Joiner.on(":").join("user ",userVo," createPlay:",playVo));
        Integer code = new Random().nextInt(10000);
        playVo.setCode(code);
        playVo.setStatus(0);
        Play play = new Play();
        BeanMapper.copy(playVo,play);
        playCrudService.insert(play);
//        String res = joinByPlayId(play.getPlayId(),userVo);
//        if(!res.equals("success")){
//            throw new BusinessException("创建后加入牌局失败");
//        }
        return code;
    }


    public Long join(PlayVo playVo, UserVo userVo) {
        List<Play> list = playCrudService.findByAll(playVo);
        if(CollectionUtils.isEmpty(list)){
            throw new BusinessException("没有找到待加入的牌局");
        }
        Play lastPlay = list.get(list.size()-1);
        userBusinessService.updateLastPlayIdByOpenId(lastPlay.getPlayId(),userVo.getOpenId());
        return lastPlay.getPlayId();
    }

    public List<UserVo> getUserList(PlayVo playVo) {
        Long playId = playVo.getPlayId();
        List<UserVo> users = getUsersOfPlay(playId);
        return users;
    }

    private List<UserVo> getUsersOfPlay(Long playId) {
        UserVo search = new UserVo();
        search.setCurrentPlayId(playId);
        return userBusinessService.getList(search);
    }
}