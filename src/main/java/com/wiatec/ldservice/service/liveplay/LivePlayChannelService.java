package com.wiatec.ldservice.service.liveplay;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.oxm.dao.LivePlayChannelDao;
import com.wiatec.ldservice.oxm.pojo.ControlPlayChannelInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author patrick
 */
@Service
public class LivePlayChannelService {

    private final Logger logger = LoggerFactory.getLogger(LivePlayChannelService.class);

    @Resource
    private LivePlayChannelDao livePlayChannelDao;

    public List<ControlPlayChannelInfo> getAllChannelId(){
        return livePlayChannelDao.selectAllChannelId();
    }

    public String getUrlById(int channelId){
        return livePlayChannelDao.selectUrlByChannelId(channelId);
    }


}
