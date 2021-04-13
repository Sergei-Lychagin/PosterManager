package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.domain.Genre.*;
import static ru.netology.domain.Genre.THRILLER;

class MovieRepositoryTest {
    private MovieRepository movieRepository = new MovieRepository();
    private final MovieItem first = new MovieItem(1, "film", CARTOON);
    private final MovieItem second = new MovieItem(2, "film1", COMEDY);
    private final MovieItem third = new MovieItem(3, "film2", ACTION);
    private final MovieItem fourth = new MovieItem(4, "film2", THRILLER);

    @BeforeEach
    public void setUp() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(fourth);
    }

    @Test
    public void shouldAdd() {
        MovieItem[] actual = movieRepository.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth};

        assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;
        movieRepository.removeById(idToRemove);
        MovieItem[] actual = movieRepository.findAll();
        MovieItem[] expected = new MovieItem[]{first, third, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExists() {
        int findId = 3;
        MovieItem actual = movieRepository.findById(findId);
        MovieItem expected = third;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        int findId = 4;
        MovieItem actual = movieRepository.findById(findId);

        assertNull(actual);
    }

    @Test
    public void shouldRemoveAll() {
        movieRepository.removeAll();
        MovieItem[] actual = movieRepository.removeAll();
        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(expected, actual);
    }
}