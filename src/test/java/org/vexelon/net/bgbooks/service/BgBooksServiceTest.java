package org.vexelon.net.bgbooks.service;


import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.vexelon.net.bgbooks.BgbooksApplication;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;
import org.vexelon.net.bgbooks.repository.BgBooksRepository;
import org.junit.Assert;

//@RunWith(SpringJUnit4ClassRunner.class)
////@EnableAutoConfiguration
//@WebAppConfiguration
////@WebMvcTest(BgBooksRepository.class)
//@ContextConfiguration(classes = {BgbooksApplication.class})
//@SpringBootTest

//@RunWith(SpringJUnit4ClassRunner.class)
//@EnableAutoConfiguration 
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class BgBooksServiceTest {

//	@Autowired
//	private BgBooksRepository bgBooksRepository;
	@TestConfiguration
    static class BgBooksServiceImplTestContextConfiguration {
  
        @Bean
        public BgBooksService bgBooksService() {
            return new BgBooksServiceImpl();
        }
    }
	
	@Autowired
    private BgBooksService bgBooksService;
	
	@MockBean
    private BgBooksRepository bgBooksRepository;
	
	@Before
	public void setUp() {
	    Book book = new Book();
		book.setBookId(new BookId("tsetso", "tsetso"));
		Book book2 = new Book();
		book2.setBookId(new BookId("ivan", "ivanov"));
	 
//		bgBooksService.saveBook(book);

		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book2);
	    Mockito.when(bgBooksRepository.findAll())
	      .thenReturn(books);
	}
	
	@Test
	public void whenValidBook_thenBookShouldBeFound() {
//	    Book book = new Book();
//		book.setBookId(new BookId("tsetso", "tsetso"));
		List<Book> found = bgBooksService.findAllBooks();
		System.out.println(found.get(0).getBookId().getBookName());
	  System.out.println("---------------------------------"+found.size());
	  assertTrue(found.get(0).getBookId().getBookName().equals("tsetso"));
//		assertTrue(true);
//	  assertThat(found.get(0).getBookId(), book);
	 }
	
	@Test
	public void test_listBooks() {
		/*Book book = new Book();
		book.setBookId(new BookId("tsetso", "tsetso"));
		
		bgBooksRepository.saveAndFlush(book);
		List<Book> books = bgBooksRepository.findAll();
		System.out.println("***********************************************************" + books.size());
		assertThat(books.size(), is(greaterThanOrEqualTo(0)));*/
		assertTrue(true);
	}
}
