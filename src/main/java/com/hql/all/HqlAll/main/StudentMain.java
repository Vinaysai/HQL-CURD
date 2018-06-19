package com.hql.all.HqlAll.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.all.HqlAll.StudentHQL;

public class StudentMain {

	public static Session s1;

	public static SessionFactory getsession() {

		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		return sf;
	}

	public void Update() {
		s1 = getsession().openSession();

		Query qry = s1.createQuery("update StudentHQL p set p.fname=?1 where p.id=1");
		qry.setParameter(1, "MY NAME IS VINAYSAI...");
		int res = qry.executeUpdate();

		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected due to update query" + res);

		s1.close();
	}

	public void Delete() {

		s1 = getsession().openSession();

		Query qry = s1.createQuery("delete from StudentHQL p where p.id=1");
	//	qry.setParameter("1", 3);
		int res = qry.executeUpdate();

		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected due to delete query" + res);
		s1.close();
	}

	public static void main(String[] args) {
//
		StudentMain sm = new  StudentMain();
//		sm.Update();
		System.out.println("Update:::");
		sm.Delete();
		 System.out.println("Select:::More::");

	}

}