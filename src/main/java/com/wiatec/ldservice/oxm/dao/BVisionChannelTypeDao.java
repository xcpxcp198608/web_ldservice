package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.BVisionChannelTypeInfo;

import java.util.List;

/**
 * @author patrick
 */
public interface BVisionChannelTypeDao {

    List<BVisionChannelTypeInfo> selectByType(String type);
}
