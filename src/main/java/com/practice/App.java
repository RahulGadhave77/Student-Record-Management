package com.practice;

import java.util.Scanner;

import repository.RepoClass;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		RepoClass repo = new RepoClass();

		Scanner sc = new Scanner(System.in);
		System.out.println("=== Welcome===");
		System.out.println("Enter a number ");
		System.out.println("1. add a Student detail");
		System.out.println("2. Get all Student List ");
		System.out.println("3. update student data ");
		System.out.println("4. delete student data ");

		int a = sc.nextInt();

		switch (a) {
		case 1:
			repo.addStudent();
			break;
			
		case 2:
			repo.getAllStudent();
			break;
			
		case 3 : 
			repo.Update();
			break;
			
		case 4:
			repo.delete();
			break;
			default:
				System.out.println("Choose Right option ");
		}

	}
}
