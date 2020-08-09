package com.surfilter.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surfilter.ssm.dao.SmUserMapper;
import com.surfilter.ssm.model.SmUser;

@Service
public class UserService {

	@Autowired
	protected SmUserMapper smUserMapper;
	
	public SmUser selectSmUserById(Integer userId){
		return smUserMapper.selectSmUserById(userId);
	}
	
	public void updateSmUser(SmUser smUser){
		smUserMapper.updateSmUser(smUser);
	}
	
	public void deleteSmUserById(Integer userId){
		smUserMapper.deleteSmUserById(userId);
	}
	
	public void insertSmUser(SmUser smUser){
		smUserMapper.insertSmUser(smUser);
	}
}
