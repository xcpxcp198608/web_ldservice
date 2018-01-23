package com.wiatec.ldservice.service;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.common.result.ResultMaster;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.oxm.dao.RemoveAppDao;
import com.wiatec.ldservice.oxm.pojo.RemoveApkInfo;
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
public class RemoveAppService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RemoveAppDao removeAppDao;

    public ResultInfo<RemoveApkInfo> selectAll(){
        List<RemoveApkInfo> removeApkInfoList = removeAppDao.selectAll();
        if(removeApkInfoList == null || removeApkInfoList.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        return ResultMaster.success(removeApkInfoList);
    }
}
