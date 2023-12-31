package samir.onlinebookstored.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import samir.onlinebookstored.Seervice.BookService;
import samir.onlinebookstored.entity.Book;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public Book addBook (@RequestBody Book book){
        return this.bookService.addBook(book);
    }
    @GetMapping("/{bookId}")
    public Book getBook (@PathVariable ("bookId") Long bookId){
        return this.bookService.getBook(bookId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(this.bookService.getBooks());
    }

    //update quiz
    @PutMapping("/")
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.updateBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long bookId) {
        this.bookService.deleteBook(bookId);
    }
}
