package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class MovieRepository {

    private MovieItem[] movies = new MovieItem[0];

    public MovieItem[] findAll() {
        return movies;

    }

    public void save(MovieItem item) {
        int length = movies.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }


    public MovieItem findById(int id) {
        for (MovieItem item : movies) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : movies) {

            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        movies = tmp;
    }

    public MovieItem[] removeAll() {
        MovieItem[] movies = new MovieItem[0];
        return movies;
    }
}
