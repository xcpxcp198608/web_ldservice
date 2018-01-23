package com.wiatec.ldservice.service;

import com.wiatec.ldservice.oxm.dao.UpgradeDao;
import com.wiatec.ldservice.oxm.pojo.UpgradeInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author patrick
 */
@Service
public class UpgradeService {

    @Resource
    private UpgradeDao upgradeDao;

    public UpgradeInfo selectOne(){
        return upgradeDao.selectOne();
    }

}
