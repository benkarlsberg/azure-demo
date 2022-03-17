package com.revature.models;

/*
    We are going to have use JPA's annotations to tell Spring what to
    with this Class and how to map it to our Database. It is an abstraction of Hibernate (ORM)
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Marks this Class as having representation in the Database (Has a Table)
@Table(name = "movies") //Provides additional info about the table. Such as name and indexes.
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id", updatable = false)
    private int id;

    private String title;

    @Column(columnDefinition = "numeric(12,2)")
    private double price;

    private boolean available;

    @Column(name = "return_date")
    private long returnDate;

}