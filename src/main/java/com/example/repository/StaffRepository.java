package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	
	public Staff findBySubject(String subject);
	public List<Staff> findByAge(Integer age);

}
