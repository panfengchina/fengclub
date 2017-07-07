package org.fengclub.core.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class CommonEntity implements Serializable {

	private static final long serialVersionUID = 968979979039604922L;

	private Date createDate;

	private String createBy;

	private Date lastUpdateDate;

	private String lastUpdateBy;

	private Date deleteDate;

	private String deleteDateBy;

	private Boolean available;

	public Date getCreateDate() {
		if (null == this.createDate) {
			return new Date();
		} else {
			return this.createDate;
		}

	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getLastUpdateDate() {
		if (null == this.lastUpdateDate) {
			return new Date();
		} else {
			return this.lastUpdateDate;
		}

	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getDeleteDate() {
		if (null == this.deleteDate) {
			return new Date();
		} else {
			return this.deleteDate;
		}
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDeleteDateBy() {
		return deleteDateBy;
	}

	public void setDeleteDateBy(String deleteDateBy) {
		this.deleteDateBy = deleteDateBy;
	}

	public Boolean isAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
