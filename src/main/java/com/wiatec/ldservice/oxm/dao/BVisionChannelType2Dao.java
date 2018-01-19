package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.BVisionChannelType2Info;

import java.util.List;

/**
 * @author patrick
 */
public interface BVisionChannelType2Dao {

    List<BVisionChannelType2Info> selectByType(String type);
}
