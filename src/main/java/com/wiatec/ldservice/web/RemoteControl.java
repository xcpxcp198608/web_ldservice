package com.wiatec.ldservice.web;

import com.wiatec.ldservice.common.result.ResultInfo;
import com.wiatec.ldservice.oxm.pojo.ControlPlayChannelInfo;
import com.wiatec.ldservice.oxm.pojo.ControlPlayInfo;
import com.wiatec.ldservice.service.ControlPlayService;
import com.wiatec.ldservice.service.liveplay.LivePlayChannelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/control")
public class RemoteControl {

    @Resource
    private ControlPlayService controlPlayService;
    @Resource
    private LivePlayChannelService livePlayChannelService;

    @RequestMapping(value = "/")
    public String list(Model model){
        List<ControlPlayInfo> controlPlayInfoList = controlPlayService.list();
        List<ControlPlayChannelInfo> controlPlayChannelInfoList = livePlayChannelService.getAllChannelId();
        model.addAttribute("controlPlayInfoList", controlPlayInfoList);
        model.addAttribute("controlPlayChannelInfoList", controlPlayChannelInfoList);
        return "control/play";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public ResultInfo update(ControlPlayInfo controlPlayInfo, int channelId){
        if(channelId > 1){
            String url = livePlayChannelService.getUrlById(channelId);
            controlPlayInfo.setUrl(url);
        }
        return controlPlayService.update(controlPlayInfo);
    }
}
