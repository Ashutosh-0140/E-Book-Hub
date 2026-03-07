package com.example.BookStore.db;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Entity
@Data
@Table(name="Books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    @NotBlank(message = "Book name Can not be empty.")
    private String bName;

    @NotBlank(message = "Author name can't be empty.")
    private String Author_name;

    @Positive(message = "Price must be positive.")
    private Double Price;

    @Min(value =0 , message = "Stock can't be negative.")
    private Integer Stock;
}
