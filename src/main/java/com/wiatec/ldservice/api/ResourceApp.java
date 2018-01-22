package com.wiatec.ldservice.api;

import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.oxm.pojo.ResourceAppInfo;
import com.wiatec.ldservice.service.ResourceAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 * @author xuchengpeng
 * @date 25/07/2017
 */
@Controller
@RequestMapping(value = "/resource")
@ResponseBody
public class ResourceApp {

    @Resource
    private ResourceAppService resourceAppService;

    @GetMapping(value = "/{userLevel}")
    public ResultInfo<ResourceAppInfo> getByType(@PathVariable int userLevel){
        return resourceAppService.selectByUserLevel(userLevel);
    }

}
