package com.rd.jpa.junit;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import com.rd.jpa.entity.User;
import com.rd.jpa.util.HibernateUtil;

public class UserTest {

	@Test
	public void testSave() {
		User user = new User();
		user.setName("金伟");
		user.setAddress("浙江省杭州市西湖区文三路90号东部软件园");
		user.setAge(25);
		user.setSex("男");
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);

		tx.commit();
		HibernateUtil.closeSession();
	}

	@Test
	public void testQuery() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery(
				"select u from User u").list();

		for (User user : userList) {
			System.out.println(user);
		}

		session.getTransaction().commit();
	}
}