package repository;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entity.StudentDetail;
import utility.StudentHibernate;

public class RepoClass {

	Scanner sc = new Scanner(System.in);

	public void addStudent() {

		StudentDetail student = new StudentDetail();

		System.out.println("Enter Student Id ");
		int id = sc.nextInt();
		student.setId(id);

		System.out.println("Enter your name ");
		String name = sc.next();
		student.setName(name);

		System.out.println("Enter your email Id");
		String email = sc.next();
		student.setEmail(email);

		System.out.println("Enter your course");
		String course = sc.next();
		student.setCourse(course);

		System.out.println("Enter your mark");
		int mark = sc.nextInt();
		student.setMarks(mark);

		SessionFactory factory = StudentHibernate.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(student);

		transaction.commit();
		session.close();
	}

	public void getAllStudent() {

		SessionFactory factory = StudentHibernate.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<StudentDetail> studentlist = session.createQuery("select s from StudentDetail s", StudentDetail.class)
				.getResultList();

		studentlist.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}

	public void Update() {
		SessionFactory factory = StudentHibernate.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Student Id to update");
		int studentId = sc.nextInt();
		StudentDetail s = session.find(StudentDetail.class, studentId);

		System.out.println("Enter your Name ");
		String name = sc.next();
		s.setName(name);

		System.out.println("Enter your email Id");
		String email = sc.next();
		s.setEmail(email);

		System.out.println("Enter your course");
		String course = sc.next();
		s.setCourse(course);

		System.out.println("Enter your Marks");
		int mark = sc.nextInt();
		s.setMarks(mark);

		transaction.commit();
		session.close();
	}

	public void delete() {
		SessionFactory factory = StudentHibernate.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter your Id");
		int id = sc.nextInt();
		StudentDetail s = session.find(StudentDetail.class, id);
		session.remove(s);

		transaction.commit();
		session.close();
	}

}
