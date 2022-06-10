package com.example.exercises;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise1 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        // Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        Map<String, Long> directorNameToMoviesCount = movies.stream()
                .map(Movie::getDirectors)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.groupingBy(
                                Director::getName,
                                Collectors.counting()
                        )
                );

        Map<String, Long> dirMovCounts = movies
                .stream()
                .map(Movie::getDirectors)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(
                        Director::getName,
                        (d) -> {
                            return (long) movieService.findAllMoviesByDirectorId(d.getId()).size();
                        },
                        (o, n) -> {
                            return o;
                        }
                ));

        System.out.println("Two versions produce the same result " + (directorNameToMoviesCount.equals(dirMovCounts)));

        dirMovCounts.forEach(
                (name, count) -> System.out.printf("%20s: %3d\n", name, count));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        directorNameToMoviesCount.forEach(
                (name, count) -> System.out.printf("%20s: %3d\n", name, count));


    }

}
