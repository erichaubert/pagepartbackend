package com.ehaubert.digabit.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class PagePartEntityTest {

	@Test 
	public void onCreate_sets_timestamps(){
		PagePartEntity pagePartEntity = new PagePartEntity();
		pagePartEntity.onCreate();
		assertNotNull(pagePartEntity.getCreated());
		assertNotNull(pagePartEntity.getUpdated());
		assertEquals(pagePartEntity.getCreated(), pagePartEntity.getUpdated());
	}
	@Test 
	public void onUpdate_sets_Updated_timestamp() throws InterruptedException{
		PagePartEntity pagePartEntity = new PagePartEntity();
		pagePartEntity.onCreate();//set Initial value
		Thread.sleep(10);//Java too many fast! we want different dates
		Date dateBeforeUpdate = pagePartEntity.getUpdated();
		pagePartEntity.onUpdate();
		assertNotNull(pagePartEntity.getUpdated());
		assertNotEquals(dateBeforeUpdate, pagePartEntity.getUpdated());
	}
}

