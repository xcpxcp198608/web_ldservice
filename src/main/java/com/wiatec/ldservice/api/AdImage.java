package com.wiatec.ldservice.api;

import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.oxm.pojo.ImageInfo;
import com.wiatec.ldservice.service.AdImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/ad_image")
@ResponseBody
public class AdImage {

    private final Logger logger = LoggerFactory.getLogger(AdImage.class);

    @Autowired
    private AdImageService adImageService;

    @RequestMapping(value = "/")
    public ResultInfo<ImageInfo> get(){
        return adImageService.getAll();
    }
}
