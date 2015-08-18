package com.ehaubert.digabit.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Part {
	@XmlAttribute
	private BigDecimal discountedPrice;//example value ="0.0"
	@XmlAttribute
	private BigInteger instanceId;//example value ="1"
	@XmlAttribute
	private String item;//example value ="1"
	@XmlAttribute
	private Boolean orderable;//example value ="true"
	@XmlAttribute
	private String partNumber;//example value ="6800759"
	@XmlAttribute
	private String quantity;//example value ="1"
	@XmlAttribute
	private BigDecimal retailPrice;//example value ="0.0"
	@XmlAttribute
	private String supplierKey;//example value ="NABI"
	@XmlAttribute
	private String unitOfMeasure;//example value ="EA"//TODO: enum?
	@XmlAttribute
	private BigDecimal wholesalePrice;//example value ="0.0"
	
	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public BigInteger getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(BigInteger instanceId) {
		this.instanceId = instanceId;
	}
	public Boolean getOrderable() {
		return orderable;
	}
	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getSupplierKey() {
		return supplierKey;
	}
	public void setSupplierKey(String supplierKey) {
		this.supplierKey = supplierKey;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public BigDecimal getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(BigDecimal wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
