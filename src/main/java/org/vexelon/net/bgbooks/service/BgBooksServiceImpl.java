package org.vexelon.net.bgbooks.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;
import org.vexelon.net.bgbooks.repository.BgBooksRepository;


@Service("bgBooksSerivce")
public class BgBooksServiceImpl implements BgBooksService{
	
	private static final Logger logger = LoggerFactory.getLogger(BgBooksServiceImpl.class);
	
	@Autowired
	private BgBooksRepository bgBooksRepository;
	
	public void saveBooks() {
		
		Book book = new Book();
		book.setBookId(new BookId("tsetso", "tsetso"));
		
		bgBooksRepository.saveAndFlush(book);
	}
	
//	public List<Book> listBooks(){
//		return bgBooksRepository.findAll();
//	}

	@Override
	public List<Book> findAllBooks() {
//		logger.error("***************************in find all books method");
		return bgBooksRepository.findAll();
	}

	@Override
	public Book findById(BookId bookId) {
		return bgBooksRepository.findOne(bookId);
	}

	@Override
	public void saveBook(Book book) {
		bgBooksRepository.saveAndFlush(book);
		
	}

	@Override
	public boolean isBookExist(Book book) {
		return findById(book.getBookId()) != null;
	}
	
}
