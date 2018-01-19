package com.wiatec.ldservice.service;

import com.wiatec.ldservice.oxm.dao.UpgradeDao;
import com.wiatec.ldservice.oxm.pojo.UpgradeInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class UpgradeService {

    @Resource
    private UpgradeDao upgradeDao;

    @Transactional
    public UpgradeInfo selectOne(){
        return upgradeDao.selectOne();
    }

}
