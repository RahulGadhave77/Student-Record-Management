package repository;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entity.Document;
import Entity.StudentDetail;
import utility.StudentHibernate;
//Repository class
public class RepoClass {

	Scanner sc = new Scanner(System.in);
	//post data
	public void addStudent() {

		Document document = new Document();

		System.out.println("Enter a Adhar no");
		long adhar = sc.nextLong();
		document.setAdharNo(adhar);

		System.out.println("Enter Pan No");
		String panNo = sc.next();
		document.setPanNo(panNo);

		StudentDetail student = new StudentDetail();

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

		// for student document
		student.setDocument(document);

		SessionFactory factory = StudentHibernate.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(student);

		transaction.commit();
		session.close();
	}
	//get all student data from data base

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
	//updata data from database

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

		System.out.println("Enter your updated adhar ");
		long adhar = sc.nextLong();
		s.getDocument().setAdharNo(adhar);

		System.out.println("Enter your updated pan no");
		String panNo = sc.next();
		s.getDocument().setPanNo(panNo);

		transaction.commit();
		session.close();
	}
//delete data by pk
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
