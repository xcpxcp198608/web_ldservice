package com.wiatec.ldservice.service;

import com.wiatec.ldservice.common.cache.JedisMaster;
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
        List<ResourceAppInfo> resourceAppInfoList;
        if(userLevel > 2){
            resourceAppInfoList = resourceAppDao.selectAll();
        }else {
            resourceAppInfoList = resourceAppDao.selectByType(0);
        }
        if(resourceAppInfoList == null || resourceAppInfoList.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        return ResultMaster.success(resourceAppInfoList);
    }

    public ResultInfo<ResourceAppInfo> selectByPackageName(String packageName){
        ResourceAppInfo resourceAppInfo = JedisMaster.getInstance()
                .get("ResourceAppInfo:"+ packageName, ResourceAppInfo.class);
        if(resourceAppInfo == null) {
            resourceAppInfo = resourceAppDao.selectByPackageName(packageName);
            JedisMaster.getInstance().setex("ResourceAppInfo:" + packageName, ResourceAppInfo.class,
                    resourceAppInfo, 600);
        }
        if(resourceAppInfo == null){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        return ResultMaster.success(resourceAppInfo);
    }
}
