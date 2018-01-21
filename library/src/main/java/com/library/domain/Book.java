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
@Table(name = Tables.Book.TABLE_NAME)
public class Book extends AbstractEntityAudit {
	private BigInteger id;
	private String name;
	private String author;
	private String publisher;
	private Double price;
	private Double discount;
	private Integer count;
	private String barcode;
	private String language;
	private String status;
	private String category;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Book.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = Tables.Book.Columns.AUTHOR)
	public String getAuthor() {
		return author;
	}

	@Column(name = Tables.Book.Columns.BAR_CODE)
	public String getBarcode() {
		return barcode;
	}

	@Column(name = Tables.Book.Columns.CATEGORY)
	public String getCategory() {
		return category;
	}

	@Column(name = Tables.Book.Columns.COUNT)
	public int getCount() {
		return count;
	}

	@Column(name = Tables.Book.Columns.DISCOUNT)
	public Double getDiscount() {
		return discount;
	}

	@Column(name = Tables.Book.Columns.LANGUAGE)
	public String getLanguage() {
		return language;
	}

	@Column(name = Tables.Book.Columns.BLOOD_GROUP)
	public String getName() {
		return name;
	}

	@Column(name = Tables.Book.Columns.PRICE)
	public Double getPrice() {
		return price;
	}

	@Column(name = Tables.Book.Columns.PUBLISHER)
	public String getPublisher() {
		return publisher;
	}

	@Column(name = Tables.Book.Columns.STATUS)
	public String getStatus() {
		return status;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return " Book [ name=" + name + ", author=" + author + ", publisher=" + publisher + ", price=" + price
				+ ", discount=" + discount + ", count=" + count + ", barcode=" + barcode + ", language=" + language
				+ ", status=" + status + ", category=" + category + "] ";
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, name, author, publisher, price, discount, count, barcode, language, status, category,
				super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Book)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		Book other = (Book) obj;
		Object[] obj1 = array(name, author, publisher, price, discount, count, barcode, language, status, category);
		Object[] obj2 = array(other.name, other.author, other.publisher, other.price, other.discount, other.count,
				other.barcode, other.language, other.status, other.category);
		return Arrays.deepEquals(obj1, obj2);
	}
}
