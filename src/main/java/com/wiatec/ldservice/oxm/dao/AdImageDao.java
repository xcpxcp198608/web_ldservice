package com.wiatec.ldservice.oxm.dao;

import com.wiatec.ldservice.oxm.pojo.ImageInfo;

import java.util.List;

/**
 * @author patrick
 */
public interface AdImageDao {

    List<ImageInfo> selectAll();
}
