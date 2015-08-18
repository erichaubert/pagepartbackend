package com.ehaubert.digabit.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page {
	@XmlElement(name="Part")
	private List<Part> part = new ArrayList<>();
	@XmlAttribute
	private String pageFile;
	@XmlAttribute
	private String hashKey;

	public String getPageFile() {
		return pageFile;
	}
	public void setPageFile(String pageFile) {
		this.pageFile = pageFile;
	}
	public String getHashKey() {
		return hashKey;
	}
	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}
	public List<Part> getPart() {
		return part;
	}
	public void setPart(List<Part> part) {
		this.part = part;
	}
}
