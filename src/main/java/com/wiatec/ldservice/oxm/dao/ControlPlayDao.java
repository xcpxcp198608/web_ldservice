package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.ControlPlayInfo;

import java.util.List;

/**
 * @author patrick
 */
public interface ControlPlayDao {

    void insertOne(String mac);
    ControlPlayInfo selectOne(String mac);
    void updateToNoPlay(String mac);
    List<ControlPlayInfo> selectAll();
    void updateToPlay(ControlPlayInfo controlPlayInfo);
}
