package com.revature.services;

import com.revature.models.Movie;

import java.util.List;

public interface MovieService {

    public Movie addMovie(Movie m);
    public Movie getMovie(int id);
    public List<Movie> getAllMovies();
    public Movie updateMovie(Movie change);
    public boolean deleteMovie(int id);

    List<Movie> getMovieByTitle(String title);
}