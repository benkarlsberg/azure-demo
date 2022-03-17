package com.revature.services;

import com.revature.models.Movie;
import com.revature.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    /*
    Automatically maps an Object to its instance found in the Spring Container.
    IF ONE EXISTS. If more than one instance exists, you need to add @Qualifier.
     */
    //This is Field Injection
    @Autowired
    MovieRepo mr;

    @Override
    public Movie addMovie(Movie m) {
        return mr.save(m);
    }

    @Override
    public Movie getMovie(int id) {
        //findById returns an Optional.
        return mr.findById(id).orElse(new Movie());
    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) mr.findAll();
    }

    @Override
    public Movie updateMovie(Movie change) {
        return mr.save(change);
    }

    @Override
    public boolean deleteMovie(int id) {
        try {
            mr.deleteById(id);
            return true;
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Movie> getMovieByTitle(String title) {
        return mr.findByTitle(title);
    }


}