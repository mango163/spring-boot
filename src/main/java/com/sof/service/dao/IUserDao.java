/**
 * 
 */
package com.sof.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Result;
import com.sof.service.model.User;

/**
 * @author Aaron
 *
 */
@Mapper
public interface IUserDao {
	
	@Insert("insert into user (id, name) values(#{id}, #{name})")
	@SelectKey(statement="call next value for TestSequence", keyProperty="id", before=true, resultType=int.class)
	int insertUser(String name);
	
	@Results(id = "userResult", value = {
	  @Result(property = "id", column = "id", id = true),
	  @Result(property = "loginName", column = "loginName"),
	  @Result(property = "password", column = "password")
	})
	@Select("select * from user where status = #{status}")
	public List<User> selectByState(Integer status);
	
	
}
