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
        try{
            return livePlayChannelDao.selectAllChannelId();
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }

    public String getUrlById(int channelId){
        try{
            return livePlayChannelDao.selectUrlByChannelId(channelId);
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }


}
