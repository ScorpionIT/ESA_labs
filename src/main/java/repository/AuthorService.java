package repository;

import model.Author;
import model.Book;

public interface AuthorService extends CRUDService<Author> {

    Book getLastBookByAuthor(Author author);
}
