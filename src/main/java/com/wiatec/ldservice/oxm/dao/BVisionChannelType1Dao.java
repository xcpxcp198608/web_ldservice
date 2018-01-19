package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.BVisionChannelType1Info;

import java.util.List;

/**
 * @author patrick
 */
public interface BVisionChannelType1Dao {

    List<BVisionChannelType1Info> selectByType(String type);
}
