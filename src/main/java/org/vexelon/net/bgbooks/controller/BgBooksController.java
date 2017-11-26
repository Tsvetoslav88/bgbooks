package org.vexelon.net.bgbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.service.BgBooksServiceImpl;

@RestController
@RequestMapping("api/v1")
public class BgBooksController {

	@Autowired
	BgBooksServiceImpl bgBooksService;
	
	@RequestMapping("/")
	public String home() {
		return "You can access successfully Bg books!";
	}

	
	// -------------------Retrieve All Users---------------------------------------------

	@RequestMapping(value = "/books/", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllUsers() {
		List<Book> users = bgBooksService.listBooks();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Book>>(users, HttpStatus.OK);
	}
//	@Autowired
//	private BgBooksStub bgBooksRepository;
//	
//	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
//	public List<Book> list(){
//		return bgBooksRepository.list();
//	}
	
	
}
