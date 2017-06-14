package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name="Staff.findBySubject",query="Select S from Staff S where S.subject=?1"),
@NamedQuery(name="Staff.findByAge",query="Select S from Staff S where S.age=?1")})
public class Staff {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String depart;
	
	@Column(name="subject",unique=true)
	private String subject;
	
	@Column(name="age")
	private Integer age;
	
	public String getSubject() {
		return subject;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDepart() {
		return depart;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Staff()
	{
		
}
	public Staff(String name)
	{
		super();
		this.name = name;
}	
	public Staff(String name,Integer id,String depart,String subject,Integer age)
	{
		super();
		this.name = name;
		this.id = id;
		this.depart = depart;
		this.subject=subject;
		this.age=age;
}		
}
