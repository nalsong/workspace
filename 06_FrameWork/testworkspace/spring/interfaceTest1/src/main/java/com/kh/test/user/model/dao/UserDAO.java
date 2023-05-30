package com.kh.test.user.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.test.user.model.vo.User;

@Repository
public class UserDAO {

	
	@Autowired
	private SqlSession Sql;

	public List<User> search(String userId) {
		return Sql.selectList("UserMapper.search", userId);
	}

}
