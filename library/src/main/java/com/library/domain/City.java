package com.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.library.common.Tables;

@Entity
@Table(name = Tables.City.TABLE_NAME)
public class City extends AbstractEntityAudit {
	private String code;
	private String name;
 
	@Id 
	@Column(name = Tables.City.Columns.CODE, unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = Tables.City.Columns.NAME, nullable = false)
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
