package tadjik.ilyosjon.endpoint.model;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false , unique = true )
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private Long isbn;
    @Column(nullable = false)
    private String status;

    public Book(Integer id, String title, String author, String publisher, Long isbn, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.status = status;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn=" + isbn +
                ", status='" + status + '\'' +
                '}';
    }
}
