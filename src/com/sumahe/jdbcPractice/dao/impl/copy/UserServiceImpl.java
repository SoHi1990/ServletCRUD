package com.sumahe.jdbcPractice.dao.impl.copy;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sumahe.jdbcPractice.Bean.User;
import com.sumahe.jdbcPractice.Proxy.JdbcConnnecter;
import com.sumahe.jdbcPractice.dao.UserService;

public class UserServiceImpl implements UserService {
	JdbcConnnecter jdbcConnnecter = new JdbcConnnecter();
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into userTable(id,code,name,password)values(NewID(),'"
				+user.getCode()+"','"
				+user.getName()+"','"
				+user.getPassword()+"')";
			jdbcConnnecter.executeSql(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String id) {
		try {
			String sql = "delete from userTable where id="+id;
			jdbcConnnecter.executeSql(sql);
		} catch (Exception e) {
			
		}
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		try{
			String sql="select * from userTable";
			ResultSet resultSet = jdbcConnnecter.getTable(sql);
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString(1));
				user.setCode(resultSet.getString(2));
				user.setName(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				userList.add(user);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}

}
