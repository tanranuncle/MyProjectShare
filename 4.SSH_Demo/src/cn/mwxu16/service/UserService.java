package cn.mwxu16.service;

import cn.mwxu16.domain.User;

public interface UserService {

	// 登陆方法
	User getUserByCodePassword(User u);

	// 注册用户
	void saveUser(User u);
}
