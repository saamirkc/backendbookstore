package samir.onlinebookstored.Seervice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samir.onlinebookstored.entity.BookCategory;
import samir.onlinebookstored.repository.BookCategoryRepository;

import java.util.HashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService{
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
        return this.bookCategoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        BookCategory bookCategory=new BookCategory();
        bookCategory.setId(categoryId);
        this.bookCategoryRepository.delete(bookCategory);

    }
}
