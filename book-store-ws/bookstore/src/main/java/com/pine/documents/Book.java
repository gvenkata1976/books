package com.pine.documents;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

@Document(collection="books")
public class Book {
  @Id
  private BigInteger id; 
  @NotNull(message = "Book Name is required")
  private String name;
  private String author;
  private String publisher;
  private Double price;
  private String barcode;
  private String language;
  private String category;
  private Boolean inStock;
  private BigInteger pages;

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Boolean getInStock() {
    return inStock;
  }

  public void setInStock(Boolean inStock) {
    this.inStock = inStock;
  }

  public BigInteger getPages() {
    return pages;
  }

  public void setPages(BigInteger pages) {
    this.pages = pages;
  }

  @Override
  public String toString() {
    return "Book [ name=" + name + ", author=" + author + ", publisher=" + publisher + ", price=" + price + ", id=" + id
        + ", barcode=" + barcode + ", language=" + language + ", category=" + category + ", inStock=" + inStock
        + ", pages=" + pages + "]";
  }
  @Override
  public boolean equals(Object obj) {
      if (StringUtils.isEmpty(id))
          return super.equals(obj);

      return getClass().isInstance(obj) && id.equals(((Book) obj).getId());
  }

  @Override
  public int hashCode() {
      return StringUtils.isEmpty(id)
          ? super.hashCode()
          : String.format("%s/%s", getClass().getSimpleName(), getId()).hashCode();
  }

}
