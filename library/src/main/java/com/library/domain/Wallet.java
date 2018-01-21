package com.library.domain;

import java.math.BigInteger;
import java.util.List;

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
@Table(name = Tables.Wallet.TABLE_NAME)
public class Wallet extends AbstractEntityAudit {

	private BigInteger id;
	private List<Card> cards;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Wallet.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	@Column(name = Tables.Wallet.Columns.WALLET_ID, unique = true, nullable = false)
	public BigInteger getId() {
		return id;
	}

	@OneToMany
	@JoinColumn(name = Tables.Wallet.Columns.CARD_ID, nullable = true, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public List<Card> getCards() {
		return cards;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
