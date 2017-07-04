package com.fengclub.biz.entity.demo;

import java.math.BigDecimal;
import java.util.List;

import org.fengclub.core.entity.CommonEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fengclub.biz.entity.common.Address;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@ApiModel(value="Test",description="调试例子用类")
public class Test extends CommonEntity{

	private static final long serialVersionUID = 280926815408162001L;

	@Id
	@ApiModelProperty(value="唯一id")
	private String id;
	
	@ApiModelProperty(value="姓名")
	private String name;
	
	@ApiModelProperty(value="年龄")
	private Integer age;
	
	@ApiModelProperty(value="分数")
	private Double score;
	
	@ApiModelProperty(value="金钱")
	private BigDecimal money;
	
	@ApiModelProperty(value="地址列表")
	private List<Address> address;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	
}
