package ru.netology.manager;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieManager {
    private MovieRepository repository;
    private int amount = 10;

    public MovieManager(int amount) {
        this.amount = amount;
    }

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }


    public void add(MovieItem item) {
        repository.save(item);
    }

    public MovieItem[] getAll(int amount) {
        MovieItem[] movies = repository.findAll();
        int length = movies.length;
        if (length > amount) {
            length = amount;
        }
        MovieItem[] result = new MovieItem[length];


        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;

            result[i] = movies[index];

        }

        return result;
    }

}
