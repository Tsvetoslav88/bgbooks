package org.vexelon.net.bgbooks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


@Entity(name = "Book")
@Table(name = "book")
public class Book implements Serializable{

	@EmbeddedId
	    @NotNull
	    private BookId bookId;

	@Column(name = "type")
	private String type; 
	
	public BookId getBookId() {
		return bookId;
	}

	public void setBookId(BookId bookId) {
		this.bookId = bookId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	 
	 
}
