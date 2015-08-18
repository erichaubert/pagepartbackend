package com.ehaubert.digabit;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.ehaubert.digabit.entity.PartEntity;
import com.ehaubert.digabit.model.Part;

public class PartManagerTest {
	private PartManager testTarget;
	private Part partInput;
	private PartEntity targetPartEntity;
	
	@Before
	public void setup(){
		testTarget = new PartManager();
		partInput = new Part();
		targetPartEntity = new PartEntity();
	}
	@Test
	public void mapToPartEntity_sets_discountedPrice() {
		partInput.setDiscountedPrice(BigDecimal.TEN);
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(10.0,targetPartEntity.getDiscountedPrice(),0.001);
	}
	@Test
	public void mapToPartEntity_sets_orderable() {
		partInput.setOrderable(Boolean.TRUE);
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals((byte)1,targetPartEntity.getOrderable());
	}
	@Test
	public void mapToPartEntity_sets_retailPrice() {
		partInput.setRetailPrice(BigDecimal.TEN);
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(10,targetPartEntity.getRetailPrice(),0.001);
	}
	@Test
	public void mapToPartEntity_sets_wholesalePrice() {
		partInput.setWholesalePrice(BigDecimal.ONE);
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(1,targetPartEntity.getWholesalePrice(),0.001);
	}
	@Test
	public void mapToPartEntity_null_discountedPrice_sets_0() {
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(0,targetPartEntity.getDiscountedPrice(),0.001);
	}
	@Test
	public void mapToPartEntity_null_orderable_sets_0() {
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals((byte)0,targetPartEntity.getOrderable());
	}
	@Test
	public void mapToPartEntity_null_retailPrice_sets_0() {
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(0,targetPartEntity.getRetailPrice(),0.001);
	}
	@Test
	public void mapToPartEntity_null_wholesalePrice_sets_0() {
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(0,targetPartEntity.getWholesalePrice(),0.001);
	}
	@Test
	public void mapToPartEntity_sets_partNumber() {
		String expected = "partNum1";
		partInput.setPartNumber(expected );
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(expected,targetPartEntity.getPartNumber());
	}
	@Test
	public void mapToPartEntity_sets_supplierKey() {
		String expected = "supKey3";
		partInput.setSupplierKey(expected);
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(expected,targetPartEntity.getSupplierKey());
	}
	@Test
	public void mapToPartEntity_sets_unitOfMeasure() {
		String expected = "uom";
		partInput.setUnitOfMeasure(expected);
		testTarget.mapToPartEntity(targetPartEntity, partInput);
		assertEquals(expected,targetPartEntity.getUnitOfMeasure());
	}
}
