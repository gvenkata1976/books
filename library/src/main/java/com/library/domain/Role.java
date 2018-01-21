package com.library.domain;

import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.library.common.Tables;

@Entity
@Table(name = Tables.Role.TABLE_NAME)
public class Role extends AbstractEntityAudit implements GrantedAuthority {
	private static final long serialVersionUID = Tables.SERIAL_VERSION_ID;
	private BigInteger id;
	private String code;
	private String authority;

	@Id
	@Column(name = Tables.Role.Columns.ROLE_ID)
	public BigInteger getId() {
		return id;
	}

	@Column(name = Tables.Role.Columns.CODE)
	public String getCode() {
		return code;
	}

	@Column(name = Tables.Role.Columns.AUTHORITY)
	@Override
	public String getAuthority() {
		return authority;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setAuthority(String name) {
		this.authority = name;
	}

	@Override
	public String toString() {
		return " Role [ id=" + id + ", authority=" + authority + "]";
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, id, authority, super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Role)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		Role other = (Role) obj;
		Object[] obj1 = array(id, authority);
		Object[] obj2 = array(other.id, other.authority);
		return java.util.Arrays.deepEquals(obj1, obj2);
	} 
}
