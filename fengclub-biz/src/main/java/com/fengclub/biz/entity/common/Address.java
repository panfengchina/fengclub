package com.fengclub.biz.entity.common;

import org.bson.types.ObjectId;
import org.fengclub.core.entity.CommonEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Address",description="地址类")
public class Address extends CommonEntity{

	private static final long serialVersionUID = -1291067693692714582L;

	@ApiModelProperty(value="唯一id")
	private ObjectId id;
	
	@ApiModelProperty(value="省市区")
	private Region region;
	
	@ApiModelProperty(value="详细地址")
	private String details;
	
	@ApiModelProperty(value="备注")
	private String remark;

	public String getId() {
		return id.toString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
