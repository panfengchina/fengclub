package com.fengclub.biz.entity.user;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ClubUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8091827021601467099L;

	@Id  
    private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
