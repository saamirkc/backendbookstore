package samir.onlinebookstored.Seervice;

import samir.onlinebookstored.entity.BookCategory;

import java.util.Set;

public interface CategoryService {

    public BookCategory addCategory(BookCategory bookCategory);
    public BookCategory updateCategory(BookCategory bookCategory);
    public Set<BookCategory> getCategories();
    public BookCategory getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);




//    public Category addCategory(Category category);
//    public Category updateCategory(Category category);
//    public Set<Category> getCategories();
//    public Category getCategory(Long categoryId);
//    public void deleteCategory(Long categoryId);
}
