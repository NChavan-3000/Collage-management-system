package com.braindatawire.collegemanagement.serviceImpl;
import java.util.*;

import com.braindatawire.collegemanagement.client.Test;
import com.braindatawire.collegemanagement.model.*;
import com.braindatawire.collegemanagement.service.Cjc;

public class Karvenagar implements Cjc 
{
	List<Course> clist=new ArrayList<>();
	List<Faculty> flist=new ArrayList<>();
	List<Batch> blist=new ArrayList<>();
	List<Student> slist=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	//Test t=new Test();
	int count=0;
	int count1=0;
	int count2=0;
	int count3=0;

	@Override
	public void addCourse() 
	{
		Course c=new Course();
		
		while(true)	
		{
			Scanner sc=new Scanner(System.in);
		try
		{
		System.out.println("Enter Course ID here: ");
		c.setCid(sc.nextInt());
		 break;
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter Cours ID in Integer Format: ");
			
		}
		}

		System.out.println("Enter course name here");
		c.setCname(sc.next());
		System.out.println();
		clist.add(c);
		count++;
	}

	@Override
	public void viewCourse() 
	{
		if(count>0)
		{
			Iterator<Course> itr=clist.iterator();
			while(itr.hasNext())
			{
				Course c=itr.next();
				System.out.println("Course ID is: "+c.getCid());
				System.out.println("Course Name is: "+c.getCname());
				System.out.println();
			}
		}
		else
		{
			System.out.println("Add course first");
			addCourse();
		}
	}

	@Override
	public void addFaculty() 
	{
		if(count>0)
		{
		Faculty f=new Faculty();
		Iterator<Course> itr1=clist.iterator();
		System.out.println("Enter Course ID you want to add Faculty");
		int cid=sc.nextInt();
		while(itr1.hasNext())
		{
			Course c=itr1.next();
			int cid1=c.getCid();
			
			if(cid==cid1)
			{
				while(true)
				{
					Scanner sc=new Scanner(System.in);
				try
				{
				System.out.println("Enter Faculty ID here:");
				f.setFid(sc.nextInt());
				break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Enter Faculty ID in integer format");
				}
				}
				System.out.println("Enter Faculty Name here:");
				f.setFname(sc.next());
				System.out.println();
				
				f.setCourse(c);
				flist.add(f);
				count1++;
			}
		}
		Iterator<Course> itr2=clist.iterator();
		while(itr2.hasNext())
		{
			Course c=itr2.next();
			if(cid==c.getCid())
			{
				f.setCourse(c);
			}
		}
		
		}
	}

	@Override
	public void viewFaculty() 
	{
		if(count1>0)
		{
		Iterator<Faculty> itr3=flist.iterator();
		while(itr3.hasNext())
		{
			Faculty f=itr3.next();
			System.out.println("Faculty ID is: "+f.getFid());
			System.out.println("Faculty Name is: "+f.getFname());
			System.out.println("Course ID of faculty: "+f.getCourse().getCid());
			System.out.println("Course for the faculty: "+f.getCourse().getCname());
			System.out.println();
		}
		}
		else
		{
			System.out.println("Faculty is not assigned");
			addFaculty();
		}
		
	}

	@Override
	public void addBatch() 
	{
		if(count>0)
		{
		Batch b=new Batch();
		Iterator<Faculty> itr4=flist.iterator();
		System.out.println("Enter which faculty id do you want to add:");
		int fid=sc.nextInt();
		while(itr4.hasNext())
		{
			Faculty f=itr4.next();
			int fid1=f.getFid();
			
			if(fid==fid1)
			{
				while(true)
				{
					Scanner sc=new Scanner(System.in);
				try
				{
				System.out.println("Enter Bacth ID here:");
				b.setBid(sc.nextInt());
				break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Enter Batch ID in Integer Format");
				}
				}
				System.out.println("Enter Batch Name here:");
				b.setBname(sc.next());
				System.out.println();
				
				b.setFaculty(f);
				blist.add(b);
				count2++;
			}
		}
		Iterator<Faculty> itr5=flist.iterator();
		while(itr5.hasNext())
		{
			Faculty f=itr5.next();
			if(fid==f.getFid())
			{
				b.setFaculty(f);
			}
		}
		
		}
	}

	@Override
	public void viewBatch()
	{
		if(count2>0)
		{
		Iterator<Batch> itr6=blist.iterator();
		while(itr6.hasNext())
		{
			Batch b=itr6.next();
			System.out.println("Batch ID is: "+b.getBid());
			System.out.println("Batch Name is:"+b.getBname());
			System.out.println("Faculty Name: "+b.getFaculty().getFname());
			System.out.println("Faculty ID: "+b.getFaculty().getFid());
			System.out.println("Course ID: "+b.getFaculty().getCourse().getCid());
			System.out.println("Course Name: "+b.getFaculty().getCourse().getCname());
			System.out.println();
		}
		
		}
		else
		{
			System.out.println("Add Batch first");
			addBatch();
		}
		
	}

	@Override
	public void addStudent() 
	{
		Student s=new Student();
		Iterator<Batch> itr7=blist.iterator();
		System.out.println("Enter which Batch ID you want to add");
		int bid=sc.nextInt();
		while(itr7.hasNext())
		{
			Batch b=itr7.next();
			int bid1=b.getBid();
			if(bid==bid1);
			{
				while(true)
				{
					Scanner sc=new Scanner(System.in);
				try
				{
				System.out.println("Enter Student ID here:");
				s.setSid(sc.nextInt());
				break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Enter Student ID in Integer Format");
				}
				}
				System.out.println("Enter Student Name here:");
				s.setSname(sc.next());
				System.out.println();
				
				s.setBatch(b);
				slist.add(s);
				count3++;
			}
		}
		Iterator<Batch> itr8=blist.iterator();
		{
			while(itr8.hasNext())
			{
			 Batch b =itr8.next();
			 if(bid==b.getBid())
			 {
				 s.setBatch(b);
			 }
			}
		}
	}
	

	@Override
	public void viewStudent() 
	{
		if(count>0)
		{
		Iterator<Student> itr9=slist.iterator();
		while(itr9.hasNext())
		{
			Student s=itr9.next();
			System.out.println("Student ID is: "+s.getSid());
			System.out.println("Student Name is: "+s.getSname());
			System.out.println("Student's Batch ID is: "+s.getBatch().getBid());
			System.out.println("Student's Batch Name is:"+s.getBatch().getBname());
			System.out.println("Student's Batch Faculty ID is: "+s.getBatch().getFaculty().getFid());
			System.out.println("Student's Batch Faculty Name is:"+s.getBatch().getFaculty().getFname());
			System.out.println("Student's Course ID is: "+s.getBatch().getFaculty().getCourse().getCid());
			System.out.println("Student's Course Name is: "+s.getBatch().getFaculty().getCourse().getCname());
		}
		
		}
		else
		{
			System.out.println("Add Student first");
			addStudent();
		}
		
	}

}
