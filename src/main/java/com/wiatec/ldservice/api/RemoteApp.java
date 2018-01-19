package com.wiatec.ldservice.api;

import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.oxm.pojo.RemoteApkInfo;
import com.wiatec.ldservice.service.RemoteAppService;
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
@RequestMapping(value = "/remote")
@ResponseBody
public class RemoteApp {

    @Resource
    private RemoteAppService remoteAppService;

    @GetMapping(value = "/")
    public ResultInfo<RemoteApkInfo> getAll(){
        return remoteAppService.selectAll();
    }

}
