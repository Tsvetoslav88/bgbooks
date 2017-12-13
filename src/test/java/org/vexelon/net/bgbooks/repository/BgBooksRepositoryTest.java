package org.vexelon.net.bgbooks.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BgBooksRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private BgBooksRepository bgBooksRepository;
	
	@Test
	public void whenFindAll_thenReturnBooks() {
	    // given
		Book book = new Book();
		book.setBookId(new BookId("tsetso", "tsetso"));
		entityManager.persist(book);
	    entityManager.flush();
	 
	    // when
//	    Book found = bgBooksRepository.findByName(alex.getName());
	    List<Book> found = bgBooksRepository.findAll();

	    System.out.println("******************---------" + found.size());
	    
	    //then
	    assertTrue(found.size()>0);
	    //TODO - check if new added row exists
	    
	}
	
	@Test
	public void whenFindByBookId_thenReturnBook() {
	    // given
		Book book = new Book();
		book.setBookId(new BookId("tsetso", "tsetso"));
		entityManager.persist(book);
	    entityManager.flush();
	 
	    // when
	    Book found = bgBooksRepository.findOne(book.getBookId());
	    
	    // then
	    assertThat(found.getBookId())
	      .isEqualTo(book.getBookId());
	}
	
}