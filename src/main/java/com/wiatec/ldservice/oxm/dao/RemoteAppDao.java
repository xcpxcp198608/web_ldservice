package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.RemoteApkInfo;

import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 25/07/2017
 */
public interface RemoteAppDao {
    List<RemoteApkInfo> selectAll();
}
