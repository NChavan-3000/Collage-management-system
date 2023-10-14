package com.braindatawire.collegemanagement.client;

import java.util.Scanner;

import com.braindatawire.collegemanagement.service.Cjc;
import com.braindatawire.collegemanagement.serviceImpl.Karvenagar;

public class Test {

	public static void main(String[] args)
	{
		Cjc c=new Karvenagar();
		System.out.println("----College Management System----");
		System.out.println(" To add data press 1."
		+"\n To exit press any number except one.");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		if(i==1)
		{
		while(true)
		{
			System.out.println(" Press 1 for Add Course"+
								"\n Press 2 for View Course"+
								"\n Press 3 for Add Faculty"+
								"\n Press 4 for View Faculty"+
								"\n Press 5 for Add Batch"+
								"\n Press 6 for View Batch"+
								"\n Press 7 for Add Student"+
								"\n Press 8 for View Student"+
								"\n Press 9 for exit");
			System.out.println(" Select any one choice from the above");
			System.out.println("");
			
			int Choice=sc.nextInt();
			
			switch(Choice)
			{
			case 1 :c.addCourse();
			break;
			
			case 2 :c.viewCourse();
			break;
			
			case 3 :c.addFaculty();
			break;
			
			case 4 :c.viewFaculty();
			break;
			
			case 5 :c.addBatch();
			break;
			
			case 6 :c.viewBatch();
			break;
			
			case 7 :c.addStudent();
			break;
			
			case 8 :c.viewStudent();
			break;
			
			case 9 :System.exit(0);
			break;
			
			default:System.exit(Choice);
			}
		}
		
		}
	}

}
