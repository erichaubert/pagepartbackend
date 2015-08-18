package com.ehaubert.digabit.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class PartEntityTest {

	@Test 
	public void onCreate_sets_timestamps(){
		PartEntity partEntity = new PartEntity();
		partEntity.onCreate();
		assertNotNull(partEntity.getCreated());
		assertNotNull(partEntity.getUpdated());
		assertEquals(partEntity.getCreated(), partEntity.getUpdated());
	}
	@Test 
	public void onUpdate_sets_Updated_timestamp() throws InterruptedException{
		PartEntity partEntity = new PartEntity();
		partEntity.onCreate();//set Initial value
		Thread.sleep(10);//Java too many fast! we want different dates
		Date dateBeforeUpdate = partEntity.getUpdated();
		partEntity.onUpdate();
		assertNotNull(partEntity.getUpdated());
		assertNotEquals(dateBeforeUpdate, partEntity.getUpdated());
	}
}
