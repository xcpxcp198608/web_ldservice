package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.RemoveApkInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 25/07/2017
 */
@Repository
public interface RemoveAppDao {

    /**
     * select all remove app information
     * @return List<RemoveApkInfo>
     */
    List<RemoveApkInfo> selectAll();
}
