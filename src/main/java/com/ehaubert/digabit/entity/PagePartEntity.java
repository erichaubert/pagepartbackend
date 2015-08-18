package com.ehaubert.digabit.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="pagepart")
public class PagePartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private int instanceId;

	private String item;

	private String quantity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	private int version;

	@ManyToOne
	private PageEntity page;

	@ManyToOne
	private PartEntity part;
	
	public PagePartEntity() {
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

	public int getInstanceId() {
		return this.instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public PageEntity getPage() {
		return this.page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
	}

	public PartEntity getPart() {
		return this.part;
	}

	public void setPart(PartEntity part) {
		this.part = part;
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