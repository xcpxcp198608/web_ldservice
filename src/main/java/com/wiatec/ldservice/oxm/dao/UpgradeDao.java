package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.UpgradeInfo;
import org.springframework.stereotype.Repository;

/**
 * @author patrick
 */
@Repository
public interface UpgradeDao {

    /**
     * select upgrade info
     * @return UpgradeInfo
     */
    UpgradeInfo selectOne();
}
