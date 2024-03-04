package samir.onlinebookstored.Seervice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import samir.onlinebookstored.entity.Book;
import samir.onlinebookstored.entity.BookCategory;
import samir.onlinebookstored.repository.BookCategoryRepository;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${upload.directory}")
    private String uploadDirectory;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    @Override
    public BookCategory addCategory(BookCategory bookCategory) {
        return this.bookCategoryRepository.save(bookCategory);
    }

    @Override
    public BookCategory updateCategory(BookCategory bookCategory) {
        return this.bookCategoryRepository.save(bookCategory);
    }

    @Override
    public Set<BookCategory> getCategories() {
        return new HashSet<>(this.bookCategoryRepository.findAll());
    }

    @Override
    public BookCategory getCategory(Long categoryId) {
        BookCategory bookCategories = this.bookCategoryRepository.findById(categoryId).get();
// for loop in book category
        for (Book book : bookCategories.getBook()) {


            // Load the file resource using ResourceLoader
            Resource file = resourceLoader.getResource("file:" + uploadDirectory + File.separator + book.getImageUrl());

            if (file.exists() && file.isReadable()) {
                book.setProfileImage(file);


            }
        }
        System.out.println("this is the book");
        System.out.println(bookCategories.getBook().toString());
        System.out.println("this is the book");
        return bookCategories;
    }
    @Override
    public void deleteCategory(Long categoryId) {
        BookCategory bookCategory=new BookCategory();
        bookCategory.setId(categoryId);
        this.bookCategoryRepository.delete(bookCategory);

    }
}
