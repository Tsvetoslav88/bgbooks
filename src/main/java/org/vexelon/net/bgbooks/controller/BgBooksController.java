package org.vexelon.net.bgbooks.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;
import org.vexelon.net.bgbooks.service.BgBooksService;
import org.vexelon.net.bgbooks.service.BgBooksServiceImpl;
import org.vexelon.net.bgbooks.util.CustomErrorType;

@RestController
@EnableAutoConfiguration
@RequestMapping("api/v1")
public class BgBooksController {

	private static final Logger logger = LoggerFactory.getLogger(BgBooksServiceImpl.class);

	
	@Autowired
	BgBooksService bgBooksService;
	
	@RequestMapping("/")
	public String home() {
		return "You can access successfully Bg books!";
	}

	
	// -------------------Retrieve All Users---------------------------------------------

	@RequestMapping(value = "/bgbooks/", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllUsers() {
		List<Book> users = bgBooksService.findAllBooks();
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
	
	
	// -------------------Retrieve Single Book------------------------------------------

		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/bgbooks/{name}/{author}", method = RequestMethod.GET)
		public ResponseEntity<?> getBook(@PathVariable("name") String name, @PathVariable("author") String author) {
			BookId bookId = new BookId(name, author);
			
			logger.info("Fetching book with name " + bookId.getBookName() + " and author " + bookId.getBookAuthor());
			Book book = bgBooksService.findById(bookId);
			if (book == null) {
				logger.error("Book with name " + bookId.getBookName() + " and author " + bookId.getBookAuthor() + " not found.");
				return new ResponseEntity(new CustomErrorType("Book with name " + bookId.getBookName() + " and author " + bookId.getBookAuthor()
						+ " not found"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}

		// -------------------Create a User-------------------------------------------
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/bgbooks/", method = RequestMethod.POST)
		public ResponseEntity<?> createUser(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
			logger.info("Creating book: {}", book);

			if (bgBooksService.isBookExist(book)) {
				//TODO - fix the message - Unable to create. A User with name org.vexelon.net.bgbooks.model.BookId@bb69d101 already exist.
				logger.error("Unable to create. A User with name {} already exist", book.getBookId());
				return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
				book.getBookId() + " already exist."),HttpStatus.CONFLICT);
			}
			bgBooksService.saveBook(book);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/book/{id}").buildAndExpand(book.getBookId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
//
//		@RequestMapping(value = "/user/", method = RequestMethod.POST)
//		public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//			logger.info("Creating User : {}", user);
//
//			if (userService.isUserExist(user)) {
//				logger.error("Unable to create. A User with name {} already exist", user.getName());
//				return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
//				user.getName() + " already exist."),HttpStatus.CONFLICT);
//			}
//			userService.saveUser(user);
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
//			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//		}
//
//		// ------------------- Update a User ------------------------------------------------
//
//		@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//		public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//			logger.info("Updating User with id {}", id);
//
//			User currentUser = userService.findById(id);
//
//			if (currentUser == null) {
//				logger.error("Unable to update. User with id {} not found.", id);
//				return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
//						HttpStatus.NOT_FOUND);
//			}
//
//			currentUser.setName(user.getName());
//			currentUser.setAge(user.getAge());
//			currentUser.setSalary(user.getSalary());
//
//			userService.updateUser(currentUser);
//			return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//		}
//
//		// ------------------- Delete a User-----------------------------------------
//
//		@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//		public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
//			logger.info("Fetching & Deleting User with id {}", id);
//
//			User user = userService.findById(id);
//			if (user == null) {
//				logger.error("Unable to delete. User with id {} not found.", id);
//				return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
//						HttpStatus.NOT_FOUND);
//			}
//			userService.deleteUserById(id);
//			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//		}
//
//		// ------------------- Delete All Users-----------------------------
//
//		@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//		public ResponseEntity<User> deleteAllUsers() {
//			logger.info("Deleting All Users");
//
//			userService.deleteAllUsers();
//			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//		}
	
}
