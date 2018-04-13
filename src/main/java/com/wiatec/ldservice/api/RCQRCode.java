package com.wiatec.ldservice.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author patrick
 */
@Controller
public class RCQRCode {

    @RequestMapping(value = "/qrcode")
    public String getApk(){
        return "qrcode/result";
    }


}
