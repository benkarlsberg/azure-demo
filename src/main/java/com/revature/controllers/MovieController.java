package com.revature.controllers;

import com.revature.models.Movie;
import com.revature.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MovieController {

    @Autowired
    MovieService ms;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        System.out.println("Getting all movies");
        return ms.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") String id) {
        Movie m = ms.getMovie(Integer.parseInt(id));

        if(m.getId() != 0) return new ResponseEntity<Movie>(m, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/movies/search")
    public List<Movie> searchMovie(@RequestParam String title) {
        return ms.getMovieByTitle(title);
    }

    @PostMapping(value = "/movies", consumes = "application/json", produces = "application/json")
    public Movie addMovie(@RequestBody Movie m) {
        return ms.addMovie(m);
    }

    @PutMapping(value = "/movies/{id}", consumes = "application/json", produces = "application/json")
    public Movie updateMovie(@PathVariable("id") String id, @RequestBody Movie m) {

        m.setId(Integer.parseInt(id));
        return ms.updateMovie(m);
    }

    @DeleteMapping("movies/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") String id) {
        boolean success = ms.deleteMovie(Integer.parseInt(id));
        return new ResponseEntity<>((success) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }

}