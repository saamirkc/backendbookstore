package samir.onlinebookstored.Seervice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import samir.onlinebookstored.entity.Book;
import samir.onlinebookstored.repository.BookRepository;

import java.util.HashSet;
import java.util.Set;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Set<Book> getBooks() {
        return new HashSet<>(this.bookRepository.findAll());
    }

    @Override
    public Book getBook(Long bookId) {
        return this.bookRepository.findById(bookId).get();
    }

    @Override
    public void deleteBook(Long bookId) {
this.bookRepository.deleteById(bookId);
    }

}
