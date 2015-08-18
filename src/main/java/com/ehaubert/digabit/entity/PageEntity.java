package com.ehaubert.digabit.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="page")
@NamedQuery(name="PageEntity.findByHashKey", query="SELECT p FROM PageEntity p WHERE p.hashKey= :hashKey")
public class PageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String externalUri;

	private String hashKey;

	private byte openInNewBrowserWindow;

	private String pageFile;

	private String pagePath;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	private int version;

	@OneToMany(mappedBy="page")
	private List<PagePartEntity> pageparts;

	public PageEntity() {
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

	public String getExternalUri() {
		return this.externalUri;
	}

	public void setExternalUri(String externalUri) {
		this.externalUri = externalUri;
	}

	public String getHashKey() {
		return this.hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public byte getOpenInNewBrowserWindow() {
		return this.openInNewBrowserWindow;
	}

	public void setOpenInNewBrowserWindow(byte openInNewBrowserWindow) {
		this.openInNewBrowserWindow = openInNewBrowserWindow;
	}

	public String getPageFile() {
		return this.pageFile;
	}

	public void setPageFile(String pageFile) {
		this.pageFile = pageFile;
	}

	public String getPagePath() {
		return this.pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<PagePartEntity> getPageparts() {
		return this.pageparts;
	}

	public void setPageparts(List<PagePartEntity> pageparts) {
		this.pageparts = pageparts;
	}

	public PagePartEntity addPagepart(PagePartEntity pagepart) {
		getPageparts().add(pagepart);
		pagepart.setPage(this);
		return pagepart;
	}

	public PagePartEntity removePagepart(PagePartEntity pagepart) {
		getPageparts().remove(pagepart);
		pagepart.setPage(null);
		return pagepart;
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