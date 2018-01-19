package com.wiatec.ldservice.api;

import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.service.ControlPlayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/play")
@ResponseBody
public class AutomaticPlay {

    @Resource
    private ControlPlayService controlPlayService;

    @PostMapping(value = "/")
    public ResultInfo get(HttpServletRequest request, @RequestParam String mac){
        return controlPlayService.get(request, mac);
    }

}
