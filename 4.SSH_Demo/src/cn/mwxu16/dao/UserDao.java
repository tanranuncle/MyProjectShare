package cn.mwxu16.dao;

import cn.mwxu16.domain.User;

/*
 * UserDao接口
 */
public interface UserDao {

	//根据登陆名称查询user对象
		User getByUserCode(String usercode);
		//保存用户
		void save(User u);
}
