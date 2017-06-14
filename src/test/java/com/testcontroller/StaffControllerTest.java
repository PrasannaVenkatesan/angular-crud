package com.testcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.builder.StaffBuilder;
import com.example.controller.StaffController;
import com.example.model.Staff;
import com.example.repository.StaffRepository;

@RunWith(MockitoJUnitRunner.class) 
public class StaffControllerTest {

	private static final Staff staff1 = new StaffBuilder().id(1).name("prasanna").department("cse").subject("os").age(22).build();
	private static final Staff staff2 = new StaffBuilder().name("prasanna").department("cse").subject("os").age(22).build();
	private static final int id = 1;
	private static final Staff NEW_ITEM = new StaffBuilder().build();
	 @InjectMocks
	  private StaffController controller;
	  @Mock
	  private StaffRepository repository;
	  private ArgumentCaptor<Staff> anyItem = ArgumentCaptor.forClass(Staff.class);
	  
	  @Test
	  public void whenFindingItemsItShouldReturnAllItems() {
	    // Given that the repository returns CHECKED_ITEM and UNCHECKED_ITEM
	    given(repository.findAll()).willReturn(Arrays.asList(staff1, staff2));
	    // When looking for all items
	    assertThat(controller.display())
	    // Then it should return the CHECKED_ITEM and UNCHECKED_ITEM 
	    .containsOnly(staff1, staff2);
	  }
	  @Test
	  public void whenAddingItemItShouldReturnTheSavedItem() {
	    // Given that a NEW_ITEM is saved and flushed, a CHECKED_ITEM is returned
	    given(repository.saveAndFlush(NEW_ITEM)).willReturn(staff1);
	    // When adding a NEW_ITEM
	    assertThat(controller.create(NEW_ITEM))
	    // Then it should return the CHECKED_ITEM
	    .isSameAs(staff1);
	  }
	  @Test 
	  public void whenUpdatingItemItShouldReturnTheSavedItem() {
	    // Given that CHECKED_ITEM is returned when one is requested with CHECKED_ITEM_ID
	    given(repository.getOne(id)).willReturn(staff2);
	    // Given that a CHECKED_ITEM is saved and flushed, a CHECKED_ITEM is returned
	    given(repository.saveAndFlush(staff2)).willReturn(staff2);
	    // When updating a CHECKED_ITEM
	    assertThat(controller.update(id,staff2))
	    // Then it should return the CHECKED_ITEM
	    .isSameAs(staff2);
	  }
	  
	  @Test
	  public void whendisplayingsingleID() {
	    // Given that CHECKED_ITEM is returned when one is requested with CHECKED_ITEM_ID
	    given(repository.findOne(id)).willReturn(staff1);
	    // Given that a CHECKED_ITEM is saved and flushed, a CHECKED_ITEM is returned
	    //given(repository.saveAndFlush(staff1)).willReturn(staff1);
	    // When updating a CHECKED_ITEM
	    assertThat(controller.displayone(id))
	    // Then it should return the CHECKED_ITEM
	    .isSameAs(staff1);
	  }
	  @Test
	  public void whendisplayingvaluesbySubject() {
		  given(repository.findBySubject("id")).willReturn(staff1);
		  assertThat(controller.subjectdisplay("id"))
		  .isSameAs(staff1);
	  }
	  @Test
	  public void whendisplayingvaluesbyage() {
		  given(repository.findByAge(id)).willReturn(Arrays.asList(staff1));
		  assertThat(controller.age(id))
		  .containsOnly(staff1);
	  }
	  
	  @Test
	  public void whenDeletingAnItemItShouldUseTheRepository() {
	    // Given that an item with CHECKED_ITEM_ID is removed
	    controller.delete(id);
	    // Verify that the repository is used to delete the item
	    verify(repository).delete(id);
	  }
}
