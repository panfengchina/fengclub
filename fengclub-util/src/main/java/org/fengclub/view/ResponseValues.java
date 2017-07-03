package org.fengclub.view;

import java.io.Serializable;

/**
 *返回的视图模型类 
 *@author Art.pan
 */
public class ResponseValues implements Serializable {

	/**	
	 * 
	 */
	private static final long serialVersionUID = -995542862872325636L;
	private int code=10000;    //错误代码，正常为10000
	private String status="success";    //返回状态，正常为success
	private String message;    //错误信息，正常是空的
	private Object data;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
