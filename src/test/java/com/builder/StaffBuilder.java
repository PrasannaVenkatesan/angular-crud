package com.builder;

import com.example.model.Staff;

public class StaffBuilder {

	private Staff staff = new Staff();
	
	public StaffBuilder id(int id)
	{
		staff.setId(id);
		return this;		
	}
	
	
	public StaffBuilder name(String name)
	{
		staff.setName(name);
		return this;
	}
	public StaffBuilder department(String department)
	{
		staff.setDepart(department);
		return this;
	}
	public StaffBuilder subject(String subject)
	{
		staff.setSubject(subject);
		return this;
	}
	public StaffBuilder age(int age)
	{
		staff.setAge(age);
		return this;		
	}
	
	public Staff build()
	{
		return staff;
	}
	
	
}
