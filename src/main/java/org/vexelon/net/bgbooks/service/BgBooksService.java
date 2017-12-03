package org.vexelon.net.bgbooks.service;

import java.util.List;

import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;

public interface BgBooksService {
	List<Book> findAllBooks();
	
	Book findById(BookId bookId);
	
//	User findById(long id);
//	
//	User findByName(String name);
//	
//	void saveUser(User user);
//	
//	void updateUser(User user);
//	
//	void deleteUserById(long id);
//
//	List<User> findAllUsers();
//	
//	void deleteAllUsers();
//	
//	boolean isUserExist(User user);
}
