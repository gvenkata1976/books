package com.library.domain;

import java.math.BigInteger;
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
@Table(name = Tables.Address.TABLE_NAME)
public class Address extends AbstractEntityAudit {
	private BigInteger id;
	private String number;
	private String street;
	private String landmark;
	private String area;
	private String postalCode;
	private String city;
	private String state;
	private String country;
	private String region;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Address.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = Tables.Address.Columns.AREA)
	public String getArea() {
		return area;
	}

	@Column(name = Tables.Address.Columns.CITY)
	public String getCity() {
		return city;
	}

	@Column(name = Tables.Address.Columns.COUNTRY)
	public String getCountry() {
		return country;
	}

	@Column(name = Tables.Address.Columns.LANDMARK)
	public String getLandmark() {
		return landmark;
	}

	@Column(name = Tables.Address.Columns.SURVEY_NUMBER)
	public String getNumber() {
		return number;
	}

	@Column(name = Tables.Address.Columns.POSTAL_CODE)
	public String getPostalCode() {
		return postalCode;
	}

	@Column(name = Tables.Address.Columns.REGION)
	public String getRegion() {
		return region;
	}

	@Column(name = Tables.Address.Columns.STATE)
	public String getState() {
		return state;
	}

	@Column(name = Tables.Address.Columns.STREET)
	public String getStreet() {
		return street;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [number=" + number + ", street=" + street + ", landmark=" + landmark + ", area=" + area
				+ ", postalCode=" + postalCode + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", region=" + region + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, number, street, landmark, area, postalCode, city, state, country, region,
				super.hashCode());
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
		Address other = (Address) obj;
		Object[] obj1 = array(id, number, street, landmark, area, postalCode, city, country, region);
		Object[] obj2 = array(other.id, other.number, other.street, other.landmark, other.area, other.postalCode,
				other.city, other.country, other.region);
		return java.util.Arrays.deepEquals(obj1, obj2);
	}

}
