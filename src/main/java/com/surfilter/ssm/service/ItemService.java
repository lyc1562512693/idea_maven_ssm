package com.surfilter.ssm.service;

import com.surfilter.ssm.dao.SmItemMapper;
import com.surfilter.ssm.model.SmItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    protected SmItemMapper smItemMapper;

    public SmItem getItemById(int itemId){
        return smItemMapper.selectByPrimaryKey(itemId);
    }
}
