package com.demo.book.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String book_title;

    @NotBlank
    private String author;

    @NotBlank
    private String publisher;

    @NotBlank
    private String location;

    @NotBlank
    private String owner;

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Date updateAt;
}
