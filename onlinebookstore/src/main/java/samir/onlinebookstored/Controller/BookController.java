//package samir.onlinebookstored.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import samir.onlinebookstored.Seervice.BookService;
//import samir.onlinebookstored.entity.Book;
//
//@RestController
//@RequestMapping("/book")
//@CrossOrigin("*")
//public class BookController {
//    @Autowired
//    private BookService bookService;
//
//    @PostMapping("/")
//    public Book addBook (@RequestBody Book book){
//        return this.bookService.addBook(book);
//    }
//    @GetMapping("/{bookId}")
//    public Book getBook (@PathVariable ("bookId") Long bookId){
//        return this.bookService.getBook(bookId);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<?> getBooks() {
//        return ResponseEntity.ok(this.bookService.getBooks());
//    }
//
//    //update quiz
//    @PutMapping("/")
//    public Book updateBook(@RequestBody Book book) {
//        return this.bookService.updateBook(book);
//    }
//
//    @DeleteMapping("/{bookId}")
//    public void delete(@PathVariable("bookId") Long bookId) {
//        this.bookService.deleteBook(bookId);
//    }
//}
//




package samir.onlinebookstored.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;
import samir.onlinebookstored.Seervice.BookService;
import samir.onlinebookstored.entity.Book;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")

public class BookController {

    private final BookService bookService;
    private final ObjectMapper objectMapper;

    @Autowired
    public BookController(BookService bookService, ObjectMapper objectMapper) {
        this.bookService = bookService;
        this.objectMapper = objectMapper;
    }

    @Value("${upload.directory}")
    private String uploadDirectory;

    // ... existing code ...

    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestParam("file") MultipartFile file,
                                        @RequestParam("book") String bookJson) throws IOException {
        // Convert JSON string to Book object
        Book book = objectMapper.readValue(bookJson, Book.class);

        // Use the configured upload directory
        String filePath = uploadDirectory + File.separator + file.getOriginalFilename();


        // Save the file to the server's filesystem
        file.transferTo(new File(filePath));

        // Set the file path in the Book object
        book.setImageUrl(filePath);

        // Add the book to the database
        Book savedBook = bookService.addBook(book);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
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



    // ... existing code ...

//    @GetMapping(value = "/images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
//    public ResponseEntity<Resource> serveImage(@PathVariable String imageName) {
//        Resource file = new FileSystemResource(uploadDirectory + File.separator + imageName);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//                .body(file);
//
//
//    }
@GetMapping(value = "/images/{imageUrl}", produces = MediaType.IMAGE_JPEG_VALUE)
public ResponseEntity<Resource> serveImage(@PathVariable String imageUrl) {
    Resource file = new FileSystemResource(uploadDirectory + File.separator + imageUrl);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + file.getFilename());

    return ResponseEntity.ok()
            .headers(headers)
            .body(file);
}





}








