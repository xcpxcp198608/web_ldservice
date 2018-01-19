package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.RemoteApkInfo;
import com.wiatec.ldservice.oxm.pojo.ResourceAppInfo;

import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 25/07/2017
 */
public interface ResourceAppDao {
    List<ResourceAppInfo> selectAll();
    List<ResourceAppInfo> selectByType(int type);
}
