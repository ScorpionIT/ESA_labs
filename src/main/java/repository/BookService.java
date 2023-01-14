package repository;

import model.Author;
import model.Book;

import java.util.List;


public interface BookService extends CRUDService<Book> {

    List<Book> getBookListByAuthor(Author author);
}
