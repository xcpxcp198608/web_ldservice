package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.BVisionChannelReportInfo;

import java.util.List;

/**
 * @author patrick
 */
public interface BVisionChannelReportDao {

    List<BVisionChannelReportInfo> selectAll();
    int insertOne(BVisionChannelReportInfo bVisionChannelReportInfo);
}
