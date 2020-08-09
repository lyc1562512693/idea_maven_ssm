package com.surfilter.ssm.dao;

import com.surfilter.ssm.model.SmUser;

public interface SmUserMapper {

	SmUser selectSmUserById(Integer userId);
	
	void updateSmUser(SmUser user);
	
	void insertSmUser(SmUser user);
	
	void deleteSmUserById(Integer userId);
}
