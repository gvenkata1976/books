package com.library.domain;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.library.common.Tables;

@Entity
@Table(name = Tables.Member.TABLE_NAME)
public class Member extends AbstractEntityAudit {
	private BigInteger id;
	private String idType;
	private String idNumber;
	private String name;
	private String bloodgroup;
	private Set<Contact> contacts;
	private Set<Address> address;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Member.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = Tables.Member.Columns.BLOOD_GROUP)
	public String getBloodgroup() {
		return bloodgroup;
	}

	@Column(name = Tables.Member.Columns.MEMBER_NAME)
	public String getName() {
		return name;
	}

	@OneToMany
	@JoinColumn(name = Tables.Member.Columns.MANAGER_ID, nullable = true, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Set<Contact> getContacts() {
		return contacts;
	}

	@OneToMany
	@JoinColumn(name = Tables.Member.Columns.ADDRESS_ID, nullable = true, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Set<Address> getAddress() {
		return address;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, id, idType, idNumber, name, bloodgroup, contacts, address, super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Member)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		Member other = (Member) obj;
		Object[] obj1 = array(id, idType, idNumber, name, bloodgroup, contacts, address);
		Object[] obj2 = array(other.id, other.idType, other.idNumber, other.name, other.bloodgroup, other.contacts,
				other.address);
		return java.util.Arrays.deepEquals(obj1, obj2);
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", idType=" + idType + ", idNumber=" + idNumber + ", name=" + name + ", bloodgroup="
				+ bloodgroup + ", contacts=" + contacts + ", address=" + address + "]";
	}

}
