package com.fengclub.biz.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document
@Component("clubUser")
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
