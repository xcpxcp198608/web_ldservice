package com.wiatec.ldservice.common.cache;

import com.wiatec.ldservice.oxm.pojo.ResourceAppInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class JedisMasterTest {

    @Test
    public void setex() {
    }

    @Test
    public void get() {
    }

    @Test
    public void setList() {
        List<ResourceAppInfo> resourceAppInfoList = new ArrayList<>();
        for(int i = 0; i < 5; i ++){
            ResourceAppInfo resourceAppInfo = new ResourceAppInfo();
            resourceAppInfo.setId(i);
            resourceAppInfo.setIcon("sfs");
            resourceAppInfoList.add(resourceAppInfo);
        }
        boolean b = JedisMaster.getInstance().setList("ResourceAppInfoList", resourceAppInfoList, 300);
        System.out.println(b);
    }

    @Test
    public void getList() {
        List<ResourceAppInfo> resourceAppInfoList = JedisMaster.getInstance().getList("ResourceAppInfoList", ResourceAppInfo.class);
        System.out.println(resourceAppInfoList);
    }
}