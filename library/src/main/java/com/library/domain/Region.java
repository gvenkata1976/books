package com.library.domain;

import java.util.Objects;
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
@Table(name = Tables.Region.TABLE_NAME)
public class Region extends AbstractEntityAudit {
	private String code;
	private String name;
    private Set<Country> countries;
	@Id 
	@Column(name = Tables.Region.Columns.CODE, unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = Tables.Region.Columns.NAME,nullable = false)
	public String getName() {
		return name;
	}
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name=Tables.Country.Columns.CODE,foreignKey=@ForeignKey(name=Tables.FOREIGN_KEY_NONE))
	public Set<Country> getCountries() {
		return countries;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Region [code=" + code + ", name=" + name + ", countries=" + countries + "]";
	}
	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, this.getCode(), this.getName(), this.getCountries(),
				super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Region)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		Region other = (Region) obj;
		Object[] obj1 = array(this.getCode(), this.getName(), this.getCountries());
		Object[] obj2 = array(other.getCode(), other.getName(), other.getCountries());
		return java.util.Arrays.deepEquals(obj1, obj2);
	}

}
