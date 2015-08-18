package com.ehaubert.digabit.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class PageEntityTest {

	@Test 
	public void onCreate_sets_timestamps(){
		PageEntity pageEntity = new PageEntity();
		pageEntity.onCreate();
		assertNotNull(pageEntity.getCreated());
		assertNotNull(pageEntity.getUpdated());
		assertEquals(pageEntity.getCreated(), pageEntity.getUpdated());
	}
	@Test 
	public void onUpdate_sets_Updated_timestamp() throws InterruptedException{
		PageEntity pageEntity = new PageEntity();
		pageEntity.onCreate();//set Initial value
		Thread.sleep(10);//Java too many fast! we want different dates
		Date dateBeforeUpdate = pageEntity.getUpdated();
		pageEntity.onUpdate();
		assertNotNull(pageEntity.getUpdated());
		assertNotEquals(dateBeforeUpdate, pageEntity.getUpdated());
	}
}
