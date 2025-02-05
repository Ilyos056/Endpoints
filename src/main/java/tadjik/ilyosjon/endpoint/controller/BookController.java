package tadjik.ilyosjon.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.endpoint.Dto.BookDto;
import tadjik.ilyosjon.endpoint.model.Book;
import tadjik.ilyosjon.endpoint.model.Result;
import tadjik.ilyosjon.endpoint.service.BookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @PostMapping("/book")
    public Result addBook(@RequestBody Book book) {

        Result result = bookService.addBook(book);
        return result;
    }
    @PutMapping("/book{id}")
    public Result editBook(@PathVariable int id, @RequestBody BookDto bookDto) {
        Result result = bookService.updateBook(id, bookDto);
        return result;
    }
    @DeleteMapping("/book/{id}")
    public Result deleteBook(@PathVariable int id) {
        Result result = bookService.deleteBook(id);
        return result;
    }
}
