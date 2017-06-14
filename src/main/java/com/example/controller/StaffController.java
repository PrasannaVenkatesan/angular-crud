package com.example.controller;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Staff;
import com.example.repository.StaffRepository;


@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	@Autowired
	private StaffRepository staffrep;
	
	@RequestMapping(method = RequestMethod.POST)
	public Staff create(@RequestBody Staff staff)
	{
		staff.setId(null);
		return staffrep.saveAndFlush(staff);
	}
@RequestMapping(value="{id}",method=RequestMethod.PUT)
public Staff update(@PathVariable Integer id,@RequestBody Staff updatestaff)
{
	
	Staff staff = staffrep.getOne(id);

	
	staff.setName(updatestaff.getName());
	staff.setDepart(updatestaff.getDepart());
	staff.setAge(updatestaff.getAge());
	return staffrep.saveAndFlush(staff);
			
	
}
@RequestMapping(value="{id}",method=RequestMethod.DELETE)
public void delete(@PathVariable Integer id)
{
	staffrep.delete(id);
}
@RequestMapping(method = RequestMethod.GET)
public List<Staff> display(){
	return staffrep.findAll();
}
@RequestMapping(value="{id}",method=RequestMethod.GET)
public Staff displayone(@PathVariable Integer id)
{
	return staffrep.findOne(id);
}

@RequestMapping(value="fnd/{subject}",method=RequestMethod.GET)
public Staff subjectdisplay(@PathVariable String subject)
{
	return staffrep.findBySubject(subject);
}
@RequestMapping(value="age/{age}",method=RequestMethod.GET)
public List<Staff> age(@PathVariable Integer age)
{
	return staffrep.findByAge(age);
	
}


}
