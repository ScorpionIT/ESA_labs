package repository.impl;

import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.BookService;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class BookServiceBean implements BookService {

    public BookServiceBean() {

    }

    @Override
    public Book getById(UUID id) {
        Transaction transaction = null;
        Book book = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            book = session.get(Book.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        Transaction transaction = null;
        List<Book> bookList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bookList = session.createQuery("FROM BOOK", Book.class)
                    .getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public void create(Book book) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(book);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Book book) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(book);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getBookListByAuthor(Author author) {
        Transaction transaction = null;
        List<Book> bookList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bookList = session.createQuery("FROM BOOK WHERE author = :id", Book.class)
                    .setParameter("id", author.getId())
                    .getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bookList;
    }
}
