package com.library.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.library.common.Tables;

@Entity
@Table(name = Tables.IdentityType.TABLE_NAME)
public class IdentityType extends AbstractEntityAudit {

	private String code;
	private String name;
	private String issuedBy;

	@Id
	@Column(name = Tables.IdentityType.Columns.CODE, unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = Tables.IdentityType.Columns.NAME)
	public String getName() {
		return name;
	}

	@Column(name = Tables.IdentityType.Columns.ISSUED_BY)
	public String getIssuedBy() {
		return issuedBy;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	@Override
	public String toString() {
		return " IdentityType [ code=" + code + ", name=" + name + ", issuedBy=" + issuedBy + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Address)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		IdentityType other = (IdentityType) obj;
		Object[] obj1 = array(code, name, issuedBy);
		Object[] obj2 = array(other.code, other.name, other.issuedBy);
		return java.util.Arrays.deepEquals(obj1, obj2);
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, code, name, issuedBy, super.hashCode());
	}
}
