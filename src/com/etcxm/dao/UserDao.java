package com.etcxm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.User;
import com.etcxm.utils.JDBCUtils;
import com.sun.accessibility.internal.resources.accessibility;

public class UserDao {

	//创建JDBC对象
		private JDBCUtils util=new JDBCUtils();
		//连接数据库
		public UserDao(){
			util.getConnection();
		}
	//登录
		public User checkLogin(String username,String password) throws Exception{
			String sql = "SELECT id,username,password FROM tb_member WHERE username=? AND password=?";
			List<Object> params=new ArrayList<Object>();
			params.add(username);
			params.add(password);
			User user = util.findSimpleRefResult(sql, params, User.class);
			util.releaseConn();
			return user;
			
		}
		//注册
				public User checkRegister(String username) throws Exception{
					String sql = "SELECT username FROM tb_member WHERE username=?";
					List<Object> params=new ArrayList<Object>();
					params.add(username);
					User user = util.findSimpleRefResult(sql, params, User.class);
					util.releaseConn();
					return user;
					
				}
		
		/**
		 * 添加
		 * @param user
		 * @return 添加结果状态true/false
		 * @throws SQLException
		 */
		public boolean addUser(User user) throws SQLException{
			String sql = "INSERT INTO tb_member(id,username,password) VALUES(null,?,?)";
			List<Object> params = new ArrayList<Object>();
			params.add(user.getUsername());
			params.add(user.getPassword());
			
			boolean flag = util.updateByPreparedStatement(sql, params);
			util.releaseConn();
			return flag;
		}
		//用户通过手机注册
		public User checkByMob(String mobno) throws Exception{
			
			String sql="select username from tb_member where telp=?";
			ArrayList<Object> params = new ArrayList<Object>();
			params.add(mobno);
			User user = util.findSimpleRefResult(sql, params, User.class);
			util.releaseConn();
			return user;
			
		}
		//通过手机添加用户
		public boolean addUserBymobno(User user) throws SQLException{
			String sql = "INSERT INTO tb_member(id,password,telp) VALUES(null,?,?)";
			List<Object> params = new ArrayList<Object>();
			params.add(user.getPassword());
			params.add(user.getTelp());
			System.out.println(user.getTelp()+"dao");
			boolean flag = util.updateByPreparedStatement(sql, params);
			util.releaseConn();
			return flag;
		}
	
}
