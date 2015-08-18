package com.ehaubert.digabit;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.ehaubert.digabit.entity.PageEntity;
import com.ehaubert.digabit.entity.PagePartEntity;
import com.ehaubert.digabit.entity.PartEntity;
import com.ehaubert.digabit.model.Part;

public class PagePartManagerTest {
	PagePartEntity mapTarget;
	Part xmlPartInput;
	PagePartManager testTarget;
	
	@Before
	public void setup(){
		testTarget = new PagePartManager();
		mapTarget = new PagePartEntity();
		xmlPartInput = new Part();//We expected part to always be not null
	}
	@Test
	public void mapToPagePartEntity_sets_instanceId_null_input_to_0() {
		testTarget.mapToPagePartEntity(mapTarget, null, xmlPartInput, null);
		assertEquals(0, mapTarget.getInstanceId());
	}
	@Test
	public void mapToPagePartEntity_sets_valie_instanceId() {
		xmlPartInput.setInstanceId(BigInteger.TEN);
		testTarget.mapToPagePartEntity(mapTarget, null, xmlPartInput, null);
		assertEquals(10, mapTarget.getInstanceId());
	}
	@Test
	public void mapToPagePartEntity_sets_item() {
		String expected="asd";
		xmlPartInput.setItem(expected);
		testTarget.mapToPagePartEntity(mapTarget, null, xmlPartInput, null);
		assertEquals(expected, mapTarget.getItem());
	}
	@Test
	public void mapToPagePartEntity_sets_quantity() {
		String expected="asda";
		xmlPartInput.setQuantity(expected);
		testTarget.mapToPagePartEntity(mapTarget, null, xmlPartInput, null);
		assertEquals(expected, mapTarget.getQuantity());
	}
	@Test
	public void mapToPagePartEntity_sets_page() {
		PageEntity pageEntityInput = new PageEntity();
		testTarget.mapToPagePartEntity(mapTarget, pageEntityInput , xmlPartInput, null);
		assertEquals(pageEntityInput, mapTarget.getPage());
	}
	@Test
	public void mapToPagePartEntity_sets_part() {
		PartEntity partEntityInput = new PartEntity();
		testTarget.mapToPagePartEntity(mapTarget, null, xmlPartInput, partEntityInput );
		assertEquals(partEntityInput, mapTarget.getPart());
	}
	@Test
	public void getMatchingPagePartEntity_emptyInput_returns_returns_null(){
		assertNull(testTarget.getMatchingPagePartEntity(new PageEntity(), new Part()));
	}
	@Test
	public void getMatchingPagePartEntity_emptyListInput_returns_returns_null(){
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageparts(Collections.emptyList());
		assertNull(testTarget.getMatchingPagePartEntity(pageEntity, new Part()));
	}
	@Test
	public void getMatchingPagePartEntity_different_partNumber_returns_null(){
		String item = "sameItem";
		String supplierKey ="sameSupplier";
		
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageparts(new ArrayList<PagePartEntity>());
		PagePartEntity pagepart = new PagePartEntity();
		pagepart.setItem(item);
		PartEntity partEntity = new PartEntity();
		partEntity.setPartNumber("different2");
		partEntity.setSupplierKey(supplierKey);
		pagepart.setPart(partEntity );
		pageEntity.addPagepart(pagepart);
		
		Part part = new Part();
		part.setPartNumber("different1");
		part.setSupplierKey(supplierKey);
		part.setItem(item);
		assertNull(testTarget.getMatchingPagePartEntity(pageEntity, part));
	}
	@Test
	public void getMatchingPagePartEntity_different_item_returns_null(){
		String supplierKey ="sameSupplier";
		String partNumber ="samepartNumber";
		
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageparts(new ArrayList<PagePartEntity>());
		PagePartEntity pagepart = new PagePartEntity();
		pagepart.setItem("item1");
		PartEntity partEntity = new PartEntity();
		partEntity.setPartNumber(partNumber);
		partEntity.setSupplierKey(supplierKey);
		pagepart.setPart(partEntity );
		pageEntity.addPagepart(pagepart);
		
		Part part = new Part();
		part.setPartNumber(partNumber);
		part.setSupplierKey(supplierKey);
		part.setItem("item2");
		assertNull(testTarget.getMatchingPagePartEntity(pageEntity, part));
	}
	@Test
	public void getMatchingPagePartEntity_different_supplierKey_returns_null(){
		String item = "sameItem";
		String partNumber ="samepartNumber";
		
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageparts(new ArrayList<PagePartEntity>());
		PagePartEntity pagepart = new PagePartEntity();
		pagepart.setItem(item);
		PartEntity partEntity = new PartEntity();
		partEntity.setPartNumber(partNumber);
		partEntity.setSupplierKey("a");
		pagepart.setPart(partEntity );
		pageEntity.addPagepart(pagepart);
		
		Part part = new Part();
		part.setPartNumber(partNumber);
		part.setSupplierKey("b");
		part.setItem(item);
		assertNull(testTarget.getMatchingPagePartEntity(pageEntity, part));
	}
	@Test
	public void getMatchingPagePartEntity_same_item_same_partnumber_same_supplierKey_returns_entity(){
		String item = "sameItem";
		String partNumber ="samepartNumber";
		String supplierKey ="sameKey";
		
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageparts(new ArrayList<PagePartEntity>());
		PagePartEntity pagepart = new PagePartEntity();
		pagepart.setItem(item);
		PartEntity partEntity = new PartEntity();
		partEntity.setPartNumber(partNumber);
		partEntity.setSupplierKey(supplierKey);
		pagepart.setPart(partEntity );
		pageEntity.addPagepart(pagepart);
		
		Part part = new Part();
		part.setPartNumber(partNumber);
		part.setSupplierKey(supplierKey);
		part.setItem(item);
		assertEquals(pagepart,testTarget.getMatchingPagePartEntity(pageEntity, part));
	}
}
