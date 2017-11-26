package org.vexelon.net.bgbooks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;

public class BgBooksStub {
	private static Map<Long, Book> books = new HashMap<Long, Book>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		Book a = new Book();
		a.setBookId(new BookId("Tsetso", "Tsetso"));
		books.put(1L, a);
	}

	public static List<Book> list() {
		return new ArrayList<Book>(books.values());
	}

//	public static Shipwreck create(Shipwreck wreck) {
//		idIndex += idIndex;
//		wreck.setId(idIndex);
//		wrecks.put(idIndex, wreck);
//		return wreck;
//	}
//
//	public static Shipwreck get(Long id) {
//		return wrecks.get(id);
//	}
//
//	public static Shipwreck update(Long id, Shipwreck wreck) {
//		wrecks.put(id, wreck);
//		return wreck;
//	}
//
//	public static Shipwreck delete(Long id) {
//		return wrecks.remove(id);
//	}
}
