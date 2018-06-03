package org.vexelon.net.bgbooks.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.vexelon.net.bgbooks.model.Book;
import org.vexelon.net.bgbooks.model.BookId;
import org.vexelon.net.bgbooks.service.BgBooksService;


@RunWith(SpringRunner.class)
@WebMvcTest(BgBooksController.class)
public class BgBooksControllerTest {
    
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private BgBooksService service;
    
    @Test
    public void givenBooks_whenGetBooks_thenReturnJsonArray()
      throws Exception {
         
//        Employee alex = new Employee("alex");
        
        Book book = new Book();
		book.setBookId(new BookId("tsetso", "tsetso"));
     
        List<Book> allBooks = Arrays.asList(book);
        
        
     
//        given(service.findAllBooks()).willReturn(allBooks);
        when(service.findAllBooks()).thenReturn(allBooks);
     
        mvc.perform(get("/api/v1/bgbooks/")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
//          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].bookId.bookName", is(book.getBookId().getBookName())));
    }
}
