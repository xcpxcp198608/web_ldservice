package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.BVisionChannelLogInfo;

import java.util.List;

/**
 * @author patrick
 */
public interface BVisionChannelLogDao {

    int insertOne(BVisionChannelLogInfo bVisionChannelLogInfo);
    BVisionChannelLogInfo selectOneByTag(String tag);
    int updateOne(BVisionChannelLogInfo bVisionChannelLogInfo);
}
