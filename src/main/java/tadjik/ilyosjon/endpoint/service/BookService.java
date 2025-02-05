package tadjik.ilyosjon.endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.endpoint.Dto.BookDto;
import tadjik.ilyosjon.endpoint.model.Book;
import tadjik.ilyosjon.endpoint.model.Result;
import tadjik.ilyosjon.endpoint.repository.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    //get all book
    public List<Book> getAllBooks() {

        List<Book> bookList = bookRepo.findAll();
        return bookList;
    }
    //get by id student
    public Book getBookById(Integer id) {

        Optional<Book> Bookoptional = bookRepo.findById(id);
        return Bookoptional.get();
    }
    //create
    public Result addBook(Book book) {
        Book book1 = new Book();
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setPublisher(book.getPublisher());
        book1.setIsbn(book.getIsbn());
        bookRepo.save(book1);
        return new Result(true, "Book added successfully");
    }

    //update
    public Result updateBook(Integer id, BookDto BookDto) {
        Optional<Book> Bookoptional = bookRepo.findById(id);
        if (Bookoptional.isPresent()) {
            Book book = Bookoptional.get();
            book.setTitle(BookDto.getTitle());
            book.setAuthor(BookDto.getAuthor());
            book.setPublisher(BookDto.getPublisher());
            return new Result(true,"O`zgartirildi");
        }
        return new Result(false,"O`zgartirildi");
    }
    //delete
    public Result deleteBook(Integer id) {

        bookRepo.deleteById(id);

        return new Result(true,"Deleted");
    }

}
