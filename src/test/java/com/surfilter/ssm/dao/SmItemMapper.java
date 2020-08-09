package com.surfilter.ssm.dao;

import com.surfilter.ssm.model.SmItem;

public interface SmItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(SmItem record);

    int insertSelective(SmItem record);

    SmItem selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(SmItem record);

    int updateByPrimaryKey(SmItem record);
}