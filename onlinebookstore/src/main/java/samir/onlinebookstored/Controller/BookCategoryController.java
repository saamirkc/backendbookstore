package samir.onlinebookstored.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import samir.onlinebookstored.Seervice.CategoryService;
import samir.onlinebookstored.entity.BookCategory;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class BookCategoryController {
    @Autowired
    private CategoryService categoryService;
 @PostMapping("/")
 public ResponseEntity<BookCategory> addCategory(@RequestBody BookCategory bookCategory){
 BookCategory category1= this.categoryService.addCategory(bookCategory);
     return ResponseEntity.ok(category1);
 }

    @GetMapping("/{categoryId}")
    public BookCategory getCategory(@PathVariable("categoryId")Long categoryId){
        return this.categoryService.getCategory(categoryId);
//        System.out.println("imhit");
////        return this.categoryService.getCategory(categoryId);
//        return null;
    }
    //get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
    //update category
    @PutMapping("/")
    public BookCategory updateCategory (@RequestBody BookCategory bookCategory){
        return this.categoryService.updateCategory(bookCategory);
    }
    //delete category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
