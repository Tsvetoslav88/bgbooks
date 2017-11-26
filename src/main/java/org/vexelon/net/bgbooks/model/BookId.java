package org.vexelon.net.bgbooks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class BookId  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(name = "name", unique = true)
	@Size(min = 1, max = 200)
	private String bookName;

	@NotBlank
	@Column(name = "author", unique = true)
	@Size(min = 1, max = 100)
	private String bookAuthor;

	public BookId() {
	}
	
	
	public BookId(String bookName, String bookAuthor) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}


	public String getBookName() {
		return bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookId other = (BookId) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}


	
	

	

}
