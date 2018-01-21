package com.library.domain;

import java.math.BigInteger;
import java.util.Date;

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
@Table(name = Tables.Card.TABLE_NAME)
public class Card extends AbstractEntityAudit {
	private BigInteger id;
	private String cardNumber;
	private Date dateOfExpiry;
	private String nameOnCard;
	private String cvv;
	private String cardType;
	private Double maxLimit;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Card.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = Tables.Card.Columns.CARD_NUMBER)
	public String getCardNumber() {
		return cardNumber;
	}

	@Column(name = Tables.Card.Columns.CARD_TYPE)
	public String getCardType() {
		return cardType;
	}

	@Column(name = Tables.Card.Columns.CVV)
	public String getCvv() {
		return cvv;
	}

	@Column(name = Tables.Card.Columns.DATE_OF_EXPIRY)
	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	@Column(name = Tables.Card.Columns.MAX_LIMIT)
	public Double getMaxLimit() {
		return maxLimit;
	}

	@Column(name = Tables.Card.Columns.NAME_ON_CARD)
	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public void setMaxLimit(Double maxLimit) {
		this.maxLimit = maxLimit;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

}
