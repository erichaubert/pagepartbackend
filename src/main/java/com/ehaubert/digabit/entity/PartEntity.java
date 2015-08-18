package com.ehaubert.digabit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="part")
@NamedQuery(name="PartEntity.findBySupplierPartNumber", query="SELECT p FROM PartEntity p WHERE p.partNumber= :partNumber AND p.supplierKey= :supplierKey")
public class PartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private byte deleted;

	private double discountedPrice;

	private byte orderable;

	private String partNumber;

	private double retailPrice;

	private String supplierKey;

	private String unitOfMeasure;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	private int version;

	private double wholesalePrice;

	public PartEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public double getDiscountedPrice() {
		return this.discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public byte getOrderable() {
		return this.orderable;
	}

	public void setOrderable(byte orderable) {
		this.orderable = orderable;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public double getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getSupplierKey() {
		return this.supplierKey;
	}

	public void setSupplierKey(String supplierKey) {
		this.supplierKey = supplierKey;
	}

	public String getUnitOfMeasure() {
		return this.unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public double getWholesalePrice() {
		return this.wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	@PrePersist
	public void onCreate(){
		created = new Date();
		updated = created;
	}
	@PreUpdate
	public void onUpdate(){
		updated = new Date();
	}
}