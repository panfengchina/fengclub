package com.fengclub.biz.entity.user;

import org.fengclub.core.entity.CommonEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ClubUser extends CommonEntity {

	private static final long serialVersionUID = 6817997572160864018L;

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
