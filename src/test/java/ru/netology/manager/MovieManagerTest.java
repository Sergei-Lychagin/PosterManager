package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static ru.netology.domain.Genre.*;


import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)

public class MovieManagerTest {

    @Mock
    private MovieRepository MovieRepository;
    @InjectMocks
    private MovieManager MovieManager;
    private final MovieItem first = new MovieItem(1, "film", CARTOON);
    private final MovieItem second = new MovieItem(2, "film1", COMEDY);
    private final MovieItem third = new MovieItem(3, "film2", ACTION);
    private final MovieItem fourth = new MovieItem(4, "film3", THRILLER);

    @BeforeEach
    public void setUp() {
        MovieManager.add(first);
        MovieManager.add(second);
        MovieManager.add(third);
    }

    @Test
    public void shouldAdd() {
        MovieManager.add(fourth);

        MovieItem[] returned = new MovieItem[]{first, second, third, fourth};
        doReturn(returned).when(MovieRepository).findAll();

        MovieItem[] expected = new MovieItem[]{first, second, third, fourth};
        MovieItem[] actual = MovieRepository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {
        MovieItem[] returned = new MovieItem[]{first, second, third};
        doReturn(returned).when(MovieRepository).findAll();

        MovieItem[] expected = new MovieItem[]{third, second, first};
        MovieItem[] actual = MovieManager.getAll(10);
        assertArrayEquals(expected, actual);

    }
}