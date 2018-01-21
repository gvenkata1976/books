package com.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.library.common.Tables;

@Entity
@Table(name = Tables.Region.TABLE_NAME)
public class State extends AbstractEntityAudit {
	private String code;
	private String name;
 
	@Id 
	@Column(name = Tables.Country.Columns.CODE, unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = Tables.Country.Columns.NAME,nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
