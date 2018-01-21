package com.library.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.library.common.Tables;

@Entity
@Table(name = Tables.Contact.TABLE_NAME)

public class Contact extends AbstractEntityAudit {
	private BigInteger id;
	private String email;
	private String phone;
	private Boolean preferred = Boolean.FALSE;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Contact.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	@Column(name = Tables.Contact.Columns.CONTACT_ID, unique = true, nullable = false)
	public BigInteger getId() {
		return id;
	}

	@Column(name = Tables.Contact.Columns.EMAIL)
	public String getEmail() {
		return email;
	}

	@Column(name = Tables.Contact.Columns.PHONE)
	public String getPhone() {
		return phone;
	}

	@Column(name = Tables.Contact.Columns.IS_PREFERRED)
	public Boolean isPreferred() {
		return preferred;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPreferred(Boolean preference) {
		this.preferred = preference;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Contact)) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		Contact other = (Contact) obj;
		Object[] obj1 = array(this.getEmail(), this.getPhone(), this.isPreferred());
		Object[] obj2 = array(other.getEmail(), other.getPhone(), other.isPreferred());
		return Arrays.deepEquals(obj1, obj2);
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, this.getEmail(), this.getPhone(), this.isPreferred(), super.hashCode());
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", email=" + email + ", phone=" + phone + ", preferred=" + preferred + "]";
	} 
}
