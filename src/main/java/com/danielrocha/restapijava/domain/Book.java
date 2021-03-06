package com.danielrocha.restapijava.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String code;
	
	@Column
	private String price;
	
	@Column
	private String authors;
	
	@Column
	private String isbn;
	
	@Column
	private String publisher;
	
	@Column
	private Date publishedOn;
	
	@Column
	private Date dtInsert;

	public Book(Long id) {
		super();
		this.id = id;
	}

	public Book() {
		super();
	}
	
}
