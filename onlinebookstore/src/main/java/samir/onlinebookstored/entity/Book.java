package samir.onlinebookstored.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.core.io.Resource;

@Entity
@Table(name="tbl_book")
@Setter
@Getter
@ToString
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String stockKeepingUnit;

	private String name;


	private String description;

	@Column(name="unit_price")
	private BigDecimal unitPrice;

	@Column(name="image_url")
	private String imageUrl;


    @Lob
	private Resource profileImage;

	private boolean active;

	@Column(name="units_in_stock")
	private int unitsInStock;

	@Column(name="date_created")
	private Date createdOn;

	@Column(name="last_updated")
	private Date updatedOn;

	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	@JsonBackReference
	private BookCategory category;


	@OneToMany(cascade=CascadeType.ALL, mappedBy="book")
	@JsonManagedReference
	private Set<Review> reviews = new HashSet<>();


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
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Entity
//@Table(name = "tbl_book")
//@Setter
//@Getter
//@ToString
//public class Book {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	private String stockKeepingUnit;
//
//	private String name;
//
//	private String description;
//
//	@Column(name = "unit_price")
//	private BigDecimal unitPrice;
//
//	@Column(name = "image_url")
//	private String imageUrl;
//
//	// Add imagePath field
//	@Column(name = "image_path")
//	private String imagePath;
//
//	private boolean active;
//
//	@Column(name = "units_in_stock")
//	private int unitsInStock;
//
//	@Column(name = "date_created")
//	private Date createdOn;
//
//	@Column(name = "last_updated")
//	private Date updatedOn;
//
//	@ManyToOne
//	@JoinColumn(name = "category_id", nullable = false)
//	@JsonBackReference
//	private BookCategory category;
//}
//
