package org.vexelon.net.bgbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.repository.BgBooksRepository;

@Service("bgBooksSerivce")
public class BgBooksServiceImpl {
	
	@Autowired
	private BgBooksRepository bgBooksRepository;
	
	public List<Book> listBooks(){
		return bgBooksRepository.findAll();
	}
}
