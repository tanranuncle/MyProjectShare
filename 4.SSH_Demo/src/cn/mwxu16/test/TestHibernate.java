package cn.mwxu16.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mwxu16.dao.UserDao;
import cn.mwxu16.domain.User;
import cn.mwxu16.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHibernate {

	@Resource(name="sessionFactory")
	//通过Spring容器来注入SessionFactory对象
	private SessionFactory sf;
	
	@Test
	public void fun1() {
		
		//创建session对象
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("Jerry");
		u.setUser_name("捷锐");
		u.setUser_password("123456");
		
		session.save(u);
		
		//提交事务
		tx.commit();
		//关闭资源
		session.close();
		
	}
	
	@Test
	public void fun2() {
		//加载配置文件
		Configuration conf = new Configuration().configure();
		//创建SessionFactoy
		SessionFactory sf = conf.buildSessionFactory();
		//创建session对象
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("tom");
		u.setUser_name("汤姆");
		u.setUser_password("12345");
		
		session.save(u);
		
		//提交事务
		tx.commit();
		//关闭资源
		session.close();
		sf.close();
		
	}
	//将UserDao对象注入进来
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun3() {
		User u = ud.getByUserCode("tom");
		System.out.println(u);
	}
	
	//将UserService对象注入进来
	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun4() {
		User u = new User();
		u.setUser_code("jane");
		u.setUser_name("简");
		u.setUser_password("123456");
	
		us.saveUser(u);
		
	}
}
