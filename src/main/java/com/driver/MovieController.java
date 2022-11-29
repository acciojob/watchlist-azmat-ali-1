package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    //1
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody(required = true) Movie movie){
        movieService.addMovieS(movie);
       return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    //2
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody(required = true) Director director){
        movieService.addDirectorS(director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    //3
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam  String movie,@RequestParam String director){
        movieService.addMovieDirectorpairS(movie,director);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
    //4
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return  new ResponseEntity<>(movieService.getMovieBynameS(name), HttpStatus.ACCEPTED);
    }
    //5
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return  new ResponseEntity<>(movieService.getDirectorByNameS(name),HttpStatus.ACCEPTED);
    }
    //6
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity<>(movieService.getListofMovieByDirectorS(director),HttpStatus.ACCEPTED);
    }

    //7
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){

        return new ResponseEntity<>(movieService.getListOfAllMovieS(), HttpStatus.ACCEPTED);
    }
    //8
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByNameItMovieS(name);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    //9
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectorAndMovieS();
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }



}
