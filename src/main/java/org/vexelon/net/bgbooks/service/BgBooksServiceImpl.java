package org.vexelon.net.bgbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;
import org.vexelon.net.bgbooks.repository.BgBooksRepository;

@Service("bgBooksSerivce")
public class BgBooksServiceImpl implements BgBooksService{
	
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
		return bgBooksRepository.findAll();
	}
	
}
