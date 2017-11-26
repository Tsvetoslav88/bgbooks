package org.vexelon.net.bgbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;

public interface BgBooksRepository extends JpaRepository<Book, BookId>{
}
