package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.RemoteApkInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuchengpeng
 * @date 25/07/2017
 */
@Repository
public interface RemoteAppDao {

    /**
     * select all remote app information
     * @return List<RemoteApkInfo>
     */
    List<RemoteApkInfo> selectAll();
}
