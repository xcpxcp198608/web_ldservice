package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.ControlPlayChannelInfo;

import java.util.List;

/**
 * @author patrick
 */
public interface LivePlayChannelDao {

    List<ControlPlayChannelInfo> selectAllChannelId();
    String selectUrlByChannelId(int channelId);
}
