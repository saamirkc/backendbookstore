package samir.onlinebookstored.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "reviews")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @JsonBackReference
    private Book book;




}


//
//package samir.onlinebookstored.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "tbl_review")
//@Setter
//@Getter
//@ToString
//public class Review {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String comment;
//
//    private int rating;
//
//    @ManyToOne
//    @JoinColumn(name = "book_id", nullable = false)
//    @JsonBackReference
//    private Book book;
//
//    @Column(name = "date_created")
//    private Date createdOn;
//
//    @Column(name = "last_updated")
//    private Date updatedOn;
//}
