package com.kh.test.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.test.user.model.vo.User;

@Repository
public class UserDAO {
	
	@Autowired
	public SqlSessionTemplate sql;

	public List<User> SelectUserNum(int inputNum) {
		
		return sql.selectList("UserMapper.SelectUserNum", inputNum);
	}

}
