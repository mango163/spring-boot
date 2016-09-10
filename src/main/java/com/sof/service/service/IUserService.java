/**
 * 
 */
package com.sof.service.service;

import java.util.List;

import com.sof.service.model.User;

/**
 * @author Aaron
 *
 */

public interface IUserService {
	public void saveUser(User user);
	public List<User> selectByState(Integer status);
	int insertUser(String name);
}
