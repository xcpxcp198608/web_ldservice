package com.wiatec.ldservice.service;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.common.result.ResultMaster;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.oxm.dao.RemoteAppDao;
import com.wiatec.ldservice.oxm.pojo.RemoteApkInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 25/07/2017
 */
@Service
public class RemoteAppService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RemoteAppDao remoteAppDao;

    public ResultInfo<RemoteApkInfo> selectAll(){
        try{
            List<RemoteApkInfo> remoteApkInfoList = remoteAppDao.selectAll();
            if(remoteApkInfoList == null || remoteApkInfoList.size() <= 0){
                throw new XException(EnumResult.ERROR_NO_FOUND);
            }
            return ResultMaster.success(remoteApkInfoList);
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }
}
