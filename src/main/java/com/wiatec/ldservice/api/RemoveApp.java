package com.wiatec.ldservice.api;

import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.oxm.pojo.RemoveApkInfo;
import com.wiatec.ldservice.service.RemoveAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 * @author xuchengpeng
 * @date 25/07/2017
 */
@Controller
@RequestMapping(value = "/remove")
@ResponseBody
public class RemoveApp {

    @Resource
    private RemoveAppService removeAppService;

    @GetMapping(value = "/")
    public ResultInfo<RemoveApkInfo> getAll(){
        return removeAppService.selectAll();
    }

}
