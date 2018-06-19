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

	public static void select() {
		// Using label...............
		Session s1 = getsession().openSession();

		Query qry = s1.createQuery("from StudentHQL p where p.id= :java4s");
		qry.setParameter("java4s", 105);

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			StudentHQL p = (StudentHQL) o;
			System.out.println("---------------------------");

			System.out.println("Student Name : " + p.getFname());
			System.out.println("Last Price : " + p.getLname());
			System.out.println("---------------------------");
		}
	}

	public static void selectmore() {

		/* Using Question Mark */
		s1 = getsession().openSession();

		Query qry1 = s1.createQuery("from StudentHQL p where p.id= ?1");
		qry1.setParameter(1, 1);

		List l1 = qry1.list();
		System.out.println("Total Number Of Records : " + l1.size());
		Iterator it1 = l1.iterator();

		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			StudentHQL p = (StudentHQL) o;
			System.out.println("Student Name : " + p.getFname());
			System.out.println("Student last : " + p.getLname());
			System.out.println("---------------------------");

		}

		s1.close();
	}

	public static void main(String[] args) {

		select();
		System.out.println("Select:::");
		selectmore();
		System.out.println("Select:::More::");

	}

}