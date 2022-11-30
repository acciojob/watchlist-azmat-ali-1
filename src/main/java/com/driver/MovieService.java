package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {
@Autowired
    MovieRepository movieRepository;

    //1
    public void addMovieS(Movie movie){
        movieRepository.addMoveis(movie);
    }
    //2
    public void addDirectorS(Director director){
        movieRepository.addDirector(director);
    }
    //3
    public void addMovieDirectorpairS(String movie, String director){
        movieRepository.addMovieDirectorpair(movie,director);
    }
    //4
    public Movie getMovieBynameS(String name){
        return movieRepository.getMovieByname(name);
    }

    //5
    public Director getDirectorByNameS(String name){
        return movieRepository.getDirectorbyname(name);
    }
    //6
    public List<String> getListofMovieByDirectorS(String director){
        return movieRepository.getListofMovieByDirecto(director);
    }

    //7
    public List<Movie> getListOfAllMovieS(){
        return movieRepository.getAllMovie();
    }
    //8
    public void deleteDirectorByNameItMovieS(String name){
        movieRepository.deleteDirectorandItMovie(name);
    }
    //9
    public void deleteAllDirectorAndMovieS(){
        movieRepository.deleteAllDirectorAndMovies();
    }

}
