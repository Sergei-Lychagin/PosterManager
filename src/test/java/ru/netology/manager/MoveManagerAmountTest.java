package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;

import ru.netology.repository.MovieRepository;


import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.domain.Genre.*;

@ExtendWith(MockitoExtension.class)
public class MoveManagerAmountTest {
    //private int amount = 3;
    @Mock
    private MovieRepository MovieRepository;
    @InjectMocks
   // MovieManager manager = new MovieManager(3);
    private MovieManager MovieManager;
    private final MovieItem first = new MovieItem(1, "film", CARTOON);
    private final MovieItem second = new MovieItem(2, "film1", COMEDY);
    private final MovieItem third = new MovieItem(3, "film2", ACTION);
    private final MovieItem fourth = new MovieItem(4, "film2", THRILLER);

    @BeforeEach
    public void setUp() {
        MovieManager.add(first);
        MovieManager.add(second);
        MovieManager.add(third);
        MovieManager.add(fourth);
       // MovieManager.MovieManager(3);
    }

    @Test
    public void shouldAddWithtLimitWhenZero() {
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth};
        doReturn(returned).when(MovieRepository).findAll();

        MovieItem[] actual = MovieManager.getAll(3);
        MovieItem[] expected = new MovieItem[]{fourth, third, second};

        assertArrayEquals(expected, actual);
    }


}
