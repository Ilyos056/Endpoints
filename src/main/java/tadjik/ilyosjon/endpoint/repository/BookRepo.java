package tadjik.ilyosjon.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.endpoint.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {


    boolean existsByTitle(String title);

}
