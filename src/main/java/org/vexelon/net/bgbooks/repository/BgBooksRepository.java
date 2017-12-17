package org.vexelon.net.bgbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;

@Component("bgBooksRepository")
@Repository
public interface BgBooksRepository extends JpaRepository<Book, BookId>{
	
//	public List<Book> findAll();
//	public Book findByName(String name);
	
}
