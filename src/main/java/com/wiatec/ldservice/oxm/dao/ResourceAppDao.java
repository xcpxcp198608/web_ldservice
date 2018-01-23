package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.ResourceAppInfo;

import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 25/07/2017
 */
public interface ResourceAppDao {

    /**
     * select all resource app information
     * @return List<ResourceAppInfo>
     */
    List<ResourceAppInfo> selectAll();

    /**
     * select resource app information by type
     * @param type type: 0, 1
     * @return List<ResourceAppInfo>
     */
    List<ResourceAppInfo> selectByType(int type);

    ResourceAppInfo selectByPackageName(String packageName);
}
