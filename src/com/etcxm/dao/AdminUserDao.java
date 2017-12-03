package com.etcxm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.etcxm.entity.AdminUser;
import com.etcxm.utils.JDBCUtils;

public class AdminUserDao {
	//创建JDBC对象
	private JDBCUtils util=new JDBCUtils();
	//连接数据库
	public AdminUserDao(){
		util.getConnection();
	}
	public AdminUser queryAdmin(String username, String password) throws Exception{
		String sql = "SELECT * FROM tb_admin WHERE admin=? AND password=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		params.add(password);
		AdminUser adminuser = util.findSimpleRefResult(sql, params, AdminUser.class);
		util.releaseConn();
		return adminuser;
		
	}
	//修改管理员密码
	public boolean updateAdminPwd(String pwd,String admin) throws SQLException{
		String sql="update tb_admin set password=? where admin=?";
		List<Object> params=new ArrayList<Object>();
		params.add(pwd);
		params.add(admin);
		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
		
	}
	
	public boolean updatePassword(String username,String password) throws Exception{
		String sql = "UPDATE tb_admin SET password=? WHERE admin=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(password);
		params.add(username);
		boolean b = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return b;
		
	}
	
}
