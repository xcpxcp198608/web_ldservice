package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.RemoveApkInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class RemoveAppDaoTest {

    @Autowired
    private RemoveAppDao removeAppDao;

    @Test
    public void selectAll() {
        List<RemoveApkInfo> removeApkInfoList = removeAppDao.selectAll();
        System.out.println(removeApkInfoList);
    }

}