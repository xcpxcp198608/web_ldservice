package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.BVisionChannelInfo;

import java.util.List;

/**
 * @author patrick
 */
public interface BVisionChannelDao {

    List<BVisionChannelInfo> selectByCountry(String country);
    List<BVisionChannelInfo> selectByKey(String key);
}
