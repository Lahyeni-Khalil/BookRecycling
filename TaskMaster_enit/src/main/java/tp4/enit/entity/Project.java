package tp4.enit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
        book.setProject(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setProject(null);
    }
}
