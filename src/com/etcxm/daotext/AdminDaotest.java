package com.etcxm.daotext;

import com.etcxm.dao.AdminUserDao;
import com.etcxm.entity.AdminUser;

public class AdminDaotest {
	public static void main(String[] args) throws Exception {
		AdminUserDao dao=new AdminUserDao();
		/*AdminUser admin = dao.queryAdmin("admin", "123456");
		System.out.println(admin);*/
		boolean b = dao.updatePassword("admin", "0000");
		System.out.println(b);
		//测试管理员密码修改
		boolean flag= dao.updateAdminPwd("123", "admin");
		System.out.println(flag);
	}
}
