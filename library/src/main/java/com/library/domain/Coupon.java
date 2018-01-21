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
@Table(name = Tables.Coupon.TABLE_NAME)
public class Coupon extends AbstractEntityAudit {
	private BigInteger id;
	private String code;
	private String provider;
	private String type;
	private Double discount;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Coupon.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	public BigInteger getId() {
		return id;
	}

	@Column(name = Tables.Coupon.Columns.CODE)
	public String getCode() {
		return code;
	}

	@Column(name = Tables.Coupon.Columns.DISCOUNT)
	public Double getDiscount() {
		return discount;
	}

	@Column(name = Tables.Coupon.Columns.PROVIDER)
	public String getProvider() {
		return provider;
	}

	@Column(name = Tables.Coupon.Columns.TYPE)
	public String getType() {
		return type;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return " Coupon [ code=" + code + ", provider=" + provider + ", type=" + type + ", discount=" + discount + "]";
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, code, provider, type, discount, super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Coupon)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		Coupon other = (Coupon) obj;
		Object[] obj1 = array(this.code, this.discount, this.provider, this.type);
		Object[] obj2 = array(other.code, other.discount, other.provider, other.type);
		return java.util.Arrays.deepEquals(obj1, obj2);
	}

}
