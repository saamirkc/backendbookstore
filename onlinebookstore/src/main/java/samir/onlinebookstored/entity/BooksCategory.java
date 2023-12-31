//package samir.onlinebookstored.entity;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Entity
//@Table (name = "category")
//public class BooksCategory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String categoryName;
//    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
//    @JsonIgnore
////    private Set<Quiz> quizzes=new LinkedHashSet<>();
//    private Set<Book> books=new LinkedHashSet<>();
//    public BooksCategory() {
//    }
//
//    public BooksCategory(Long id, String categoryName) {
//        this.id = id;
//        this.categoryName = categoryName;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//}
