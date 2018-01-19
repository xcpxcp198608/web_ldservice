package com.wiatec.ldservice.oxm.dao;

import java.util.List;

/**
 * @author patrick
 */
public interface ChannelDao {

    List<Integer> selectAllChannelId();
    String selectUrlByChannelId(int channelId);
}
