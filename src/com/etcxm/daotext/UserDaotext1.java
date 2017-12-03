package com.etcxm.daotext;

import java.util.List;

import com.etcxm.dao.UserDao;
import com.etcxm.dao.shoppingCartDao;
import com.etcxm.entity.User;
import com.etcxm.entity.shoppingCart;

public class UserDaotext1 {
	public static void main(String[] args) throws Exception {
		UserDao dao = new UserDao();
		User checkLogin = dao.checkLogin("王八", "123");
		System.out.println(checkLogin+"#######");
	}
}
