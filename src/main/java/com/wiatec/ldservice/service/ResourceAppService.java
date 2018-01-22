package com.wiatec.ldservice.service;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.common.result.ResultMaster;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.oxm.dao.ResourceAppDao;
import com.wiatec.ldservice.oxm.pojo.ResourceAppInfo;
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
public class ResourceAppService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ResourceAppDao resourceAppDao;

    public ResultInfo<ResourceAppInfo> selectByUserLevel(int userLevel){
        try{
            List<ResourceAppInfo> resourceAppInfoList;
            if(userLevel > 1){
                resourceAppInfoList = resourceAppDao.selectAll();
            }else if(userLevel == 1) {
                resourceAppInfoList = resourceAppDao.selectByType(0);
            }else{
                throw new XException(EnumResult.ERROR_NO_FOUND);
            }
            if(resourceAppInfoList == null || resourceAppInfoList.size() <= 0){
                throw new XException(EnumResult.ERROR_NO_FOUND);
            }
            return ResultMaster.success(resourceAppInfoList);

        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }
}
