package com.wiatec.ldservice.api;

import com.wiatec.ldservice.oxm.pojo.UpgradeInfo;
import com.wiatec.ldservice.service.UpgradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/upgrade")
@ResponseBody
public class Upgrade {

    @Resource
    private UpgradeService upgradeService;

    @GetMapping(value = "/")
    public UpgradeInfo get(){
        return upgradeService.selectOne();
    }
}
