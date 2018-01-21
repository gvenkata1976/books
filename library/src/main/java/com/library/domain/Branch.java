package com.library.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.library.common.Tables;

@Entity
@Table(name = Tables.Branch.TABLE_NAME)
public class Branch extends AbstractEntityAudit {
	private BigInteger id;
	private String name;
	private Address address;
	private Contact contact;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Branch.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = Tables.Address.Columns.ADDRESS_ID, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Address getAddress() {
		return address;
	}

	@Column(name = Tables.Branch.Columns.BRANCH_NAME)
	public String getName() {
		return name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne
	@JoinColumn(name = Tables.Contact.Columns.CONTACT_ID, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return " Branch [name=" + name + ", address=" + address + ", contact=" + contact + "] ";
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, name, address, contact, super.hashCode());
	}

	@Override
	public boolean equals(Object obj) { 
		if (obj == this) {
			return true;
		} 
		if (!(obj instanceof Branch)) {
			return false;
		} 
		if (!super.equals(obj)) {
			return false;
		}
		Branch other = (Branch) obj;
		Object[] obj1 = array(name, address, contact);
		Object[] obj2 = array(other.name, other.address, other.contact);
		return Arrays.deepEquals(obj1, obj2);
	}
}
