package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class MovieRepository {
    //database
     Map<String,Movie> movieMap = new HashMap<>();
     Map<String,Director> directorMap = new HashMap<>();

     Map<String,List<String>> pair = new HashMap<>();


    //1
    public void addMoveis(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    //2
    public void addDirector(Director director){
        directorMap.put(director.getName(),director);
    }
     //3
     public void addMovieDirectorpair(String movie,String director){
         if(pair.containsKey(director)){
             List<String> list = pair.get(director);
             list.add(movie);
             pair.put(director,list);
         }
         else {
             List<String> list = new ArrayList<>();
                list.add(movie);
             pair.put(director,list);
         }
     }


     //4
        public Movie getMovieByname(String name){
            return movieMap.get(name);
        }



        //5

        public Director getDirectorbyname(String name){
            return directorMap.get(name);
        }

        //6
        public List<String> getListofMovieByDirecto(String name){
        List<String> list = null;
        if(pair.containsKey(name)){
            list =pair.get(name);
        }
        return list;
        }

    //7
    public List<String> getAllMovie(){
        List<String>listOfMovies = new ArrayList<>();
        for(Movie i : movieMap.values()){
            listOfMovies.add(i.getName());
        }
        return listOfMovies;
    }

        //8
        public void deleteDirectorandItMovie(String name){
            List<String> list = null;
         if(pair.containsKey(name)){
             list = pair.get(name);
             pair.remove(name);
         }

         for(String i : list){
             movieMap.remove(i);
         }
            directorMap.remove(name);
        }
        //9
        public void deleteAllDirectorAndMovies(){
            for(String directorName : directorMap.keySet()){
                deleteDirectorandItMovie(directorName);
            }

        }
}
