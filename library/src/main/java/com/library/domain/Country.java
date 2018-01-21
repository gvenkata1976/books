package com.library.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.library.common.Tables;

@Entity
@Table(name = Tables.Country.TABLE_NAME)
public class Country extends AbstractEntityAudit {
	private String code;
	private String name;
	private Set<State> states;

	@Id
	@Column(name = Tables.Country.Columns.CODE, unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = Tables.Country.Columns.NAME, nullable = false)
	public String getName() {
		return name;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	@JoinColumn(name = Tables.Country.Columns.CODE, foreignKey =@ForeignKey( name = Tables.FOREIGN_KEY_NONE ))
	public Set<State> getStates() {
		return states;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

}
