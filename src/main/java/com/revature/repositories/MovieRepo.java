package com.revature.repositories;

import com.revature.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {

    List<Movie> findByTitle(String title);

    List<Movie> findByAvailableAndPrice(boolean available, double price);

}