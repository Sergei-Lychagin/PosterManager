package ru.netology.manager;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieManager {
    public MovieManager(int amount) {
        this.amount = amount;
    }

    private int amount = 10;
    private MovieItem[] movies = new MovieItem[0];


    public void add(MovieItem item) {

        int length = movies.length + 1;
        MovieItem[] tmp = new MovieItem[length];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public MovieItem[] getAll() {
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
