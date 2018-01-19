package com.wiatec.ldservice.service;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.common.result.ResultMaster;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.oxm.dao.AdImageDao;
import com.wiatec.ldservice.oxm.pojo.ImageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author patrick
 */
@Service
public class AdImageService {

    private final Logger logger = LoggerFactory.getLogger(AdImageService.class);

    @Autowired
    private AdImageDao adImageDao;

    public ResultInfo<ImageInfo> getAll(){
        try{
            List<ImageInfo> imageInfoList = adImageDao.selectAll();
            if(imageInfoList == null || imageInfoList.size() <= 0){
                throw new XException(EnumResult.ERROR_NO_FOUND);
            }
            return ResultMaster.success(imageInfoList);
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }
    }

}
