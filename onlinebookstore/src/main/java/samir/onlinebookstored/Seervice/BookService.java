package samir.onlinebookstored.Seervice;

import samir.onlinebookstored.entity.Book;

import java.util.Set;

public interface BookService {
    public Book addBook(Book book);
    public Book updateBook(Book book);
    public Set<Book> getBooks();
    public  Book getBook(Long bookId);
    public void deleteBook(Long bookId);

}
