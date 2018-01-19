package com.wiatec.ldservice.web;

import com.wiatec.ldservice.oxm.pojo.AuthAdminInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.POST;

/**
 * @author patrick
 */
@Controller
public class Admin {

    private final Logger logger = LoggerFactory.getLogger(Admin.class);

    @PostMapping(value = "/login")
    public void login(AuthAdminInfo authAdminInfo){

    }
}
