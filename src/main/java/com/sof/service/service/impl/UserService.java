/**
 * 
 */
package com.sof.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sof.service.dao.IUserDao;
import com.sof.service.model.User;
import com.sof.service.service.IUserService;


/**
 * @author Aaron
 *
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public void saveUser(User user) {
		userDao.selectByState(1);
	}

	public List<User> selectByState(Integer status) {
		// TODO Auto-generated method stub
		return userDao.selectByState(status);
	}

	public int insertUser(String name) {
		// TODO Auto-generated method stub
		return userDao.insertUser(name);
	}

}
