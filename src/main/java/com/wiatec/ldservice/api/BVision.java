package com.wiatec.ldservice.api;

import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.oxm.pojo.*;
import com.wiatec.ldservice.service.bvision.BVisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/bvision")
@ResponseBody
public class BVision {

    private final Logger logger = LoggerFactory.getLogger(BVision.class);

    @Autowired
    private BVisionService bVisionService;

    @RequestMapping(value = "/channel/{country}/{token}")
    public ResultInfo<BVisionChannelInfo> getChannel(@PathVariable String country, @PathVariable String token){
        return bVisionService.selectChannelByCountry(country);
    }

    @RequestMapping(value = "/channel_type/{type}/{token}")
    public ResultInfo<BVisionChannelTypeInfo> getChannelType(@PathVariable String type, @PathVariable String token){
        return bVisionService.selectChannelType(type);
    }

    @RequestMapping(value = "/channel_type1/{type}/{token}")
    public ResultInfo<BVisionChannelType1Info> getChannelType1(@PathVariable String type, @PathVariable String token){
        return bVisionService.selectChannelType1(type);
    }

    @RequestMapping(value = "/channel_type2/{type}/{token}")
    public ResultInfo<BVisionChannelType2Info> getChannelType2(@PathVariable String type, @PathVariable String token){
        return bVisionService.selectChannelType2(type);
    }

    @RequestMapping(value = "/search/{key}/{token}")
    public ResultInfo<BVisionChannelInfo> search(@PathVariable String key, @PathVariable String token){
        return bVisionService.searchChannel(key);
    }

    @PostMapping(value = "/report")
    public ResultInfo report(BVisionChannelReportInfo bVisionChannelReportInfo){
        return bVisionService.report(bVisionChannelReportInfo);
    }

    @PostMapping(value = "/log/start")
    public ResultInfo logStart(BVisionChannelLogInfo bVisionChannelLogInfo){
        return bVisionService.logStart(bVisionChannelLogInfo);
    }

    @PostMapping(value = "/log/stop")
    public ResultInfo logStop(BVisionChannelLogInfo bVisionChannelLogInfo){
        return bVisionService.logStop(bVisionChannelLogInfo);

    }



}
