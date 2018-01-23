package com.wiatec.ldservice.service.bvision;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.common.result.ResultMaster;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.common.utils.AESUtil;
import com.wiatec.ldservice.common.utils.TimeUtil;
import com.wiatec.ldservice.oxm.dao.*;
import com.wiatec.ldservice.oxm.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author patrick
 */
@Service
public class BVisionService {

    private final Logger logger = LoggerFactory.getLogger(BVisionService.class);

    @Autowired
    private BVisionChannelDao bVisionChannelDao;
    @Autowired
    private BVisionChannelLogDao bVisionChannelLogDao;
    @Autowired
    private BVisionChannelReportDao bVisionChannelReportDao;
    @Autowired
    private BVisionChannelTypeDao bVisionChannelTypeDao;
    @Autowired
    private BVisionChannelType1Dao bVisionChannelType1Dao;
    @Autowired
    private BVisionChannelType2Dao bVisionChannelType2Dao;

    public ResultInfo<BVisionChannelInfo> selectChannelByCountry(String country){
        try{
            List<BVisionChannelInfo> bVisionChannelInfoList = bVisionChannelDao.selectByCountry(country);
            if(bVisionChannelInfoList == null || bVisionChannelInfoList.size() <= 0){
                throw new XException(EnumResult.ERROR_NO_FOUND);
            }
            for(BVisionChannelInfo bVisionChannelInfo: bVisionChannelInfoList){
                bVisionChannelInfo.setUrl(AESUtil.encrypt(bVisionChannelInfo.getUrl(), AESUtil.KEY));
            }
            return ResultMaster.success(bVisionChannelInfoList);
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }


    public ResultInfo<BVisionChannelInfo> searchChannel(String key){
        List<BVisionChannelInfo> bVisionChannelInfoList = bVisionChannelDao.selectByKey(key);
        if(bVisionChannelInfoList == null || bVisionChannelInfoList.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        for(BVisionChannelInfo bVisionChannelInfo: bVisionChannelInfoList){
            bVisionChannelInfo.setUrl(AESUtil.encrypt(bVisionChannelInfo.getUrl(), AESUtil.KEY));
        }
        return ResultMaster.success(bVisionChannelInfoList);
    }

    public ResultInfo<BVisionChannelTypeInfo> selectChannelType(String type){
        List<BVisionChannelTypeInfo> bVisionChannelTypeInfoList = bVisionChannelTypeDao
                .selectByType(type);
        if(bVisionChannelTypeInfoList == null || bVisionChannelTypeInfoList.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        return ResultMaster.success(bVisionChannelTypeInfoList);
    }

    public ResultInfo<BVisionChannelType1Info> selectChannelType1(String type){
        List<BVisionChannelType1Info> bVisionChannelType1InfoList = bVisionChannelType1Dao
                .selectByType(type);
        if(bVisionChannelType1InfoList == null || bVisionChannelType1InfoList.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        return ResultMaster.success(bVisionChannelType1InfoList);
    }

    public ResultInfo<BVisionChannelType2Info> selectChannelType2(String type){
        List<BVisionChannelType2Info> bVisionChannelType2InfoList = bVisionChannelType2Dao
                .selectByType(type);
        if(bVisionChannelType2InfoList == null || bVisionChannelType2InfoList.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        return ResultMaster.success(bVisionChannelType2InfoList);
    }


    public ResultInfo report(BVisionChannelReportInfo bVisionChannelReportInfo){
        bVisionChannelReportDao.insertOne(bVisionChannelReportInfo);
        return ResultMaster.success();
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultInfo logStart(BVisionChannelLogInfo bVisionChannelLogInfo){
        bVisionChannelLogInfo.setStartTime(TimeUtil.getStrTime());
        bVisionChannelLogDao.insertOne(bVisionChannelLogInfo);
        return ResultMaster.success();
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultInfo logStop(BVisionChannelLogInfo bVisionChannelLogInfo){
        BVisionChannelLogInfo bVisionChannelLogInfo1 = bVisionChannelLogDao.selectOneByTag(bVisionChannelLogInfo.getTag());
        String endTime = TimeUtil.getStrTime();
        long sTime = TimeUtil.getUnixFromStr(bVisionChannelLogInfo1.getStartTime());
        long eTime = System.currentTimeMillis();
        long vTime = eTime - sTime;
        bVisionChannelLogInfo.setEndTime(endTime);
        bVisionChannelLogInfo.setViewTime(vTime);
        bVisionChannelLogDao.updateOne(bVisionChannelLogInfo);
        return ResultMaster.success();
    }

}
