package com.fengclub.biz.entity.common;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@ApiModel(value="Region",description="省市区基础类")
public class Region implements Serializable{

	private static final long serialVersionUID = 2379879227584322094L;

	@Id
	@ApiModelProperty(value="唯一id")
	private int id;
	
	@ApiModelProperty(value="父级id")
	private int parentId;
	
	@ApiModelProperty(value="名称")
	private String name;
	
	@ApiModelProperty(value="简称")
	private String shortName;
	
	@ApiModelProperty(value="拼音（全拼）")
	private String pinyin;
	
	@ApiModelProperty(value="拼音（首字母）")
	private String py;
	
	@ApiModelProperty(value="经度")
	private double longitude;
	
	@ApiModelProperty(value="维度")
	private double latitude;
	
	@ApiModelProperty(value="行政级别")
	private int level;
	
	@ApiModelProperty(value="排序")
	private int sort;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
}
