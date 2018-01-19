package com.wiatec.ldservice.service;

import com.wiatec.ldservice.oxm.dao.ChannelDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChannelService {

    @Resource
    private ChannelDao channelDao;

    @Transactional
    public List<Integer> getAllChannelId(){
        return channelDao.selectAllChannelId();
    }

    @Transactional
    public String getUrlById(int channelId){
        return channelDao.selectUrlByChannelId(channelId);
    }

}
