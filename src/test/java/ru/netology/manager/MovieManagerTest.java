package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;


import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.domain.Genre.*;

//тесты без лимита
class MovieManagerTest {

    MovieManager manager = new MovieManager();

    private final MovieItem first = new MovieItem(1, "film", CARTOON);
    private final MovieItem second = new MovieItem(2, "film1", COMEDY);
    private final MovieItem third = new MovieItem(3, "film2", ACTION);
    private final MovieItem fourth = new MovieItem(4, "film3", THRILLER);
    private final MovieItem fifth = new MovieItem(5, "film4", CARTOON);
    private final MovieItem sixth = new MovieItem(6, "film5", COMEDY);
    private final MovieItem seventh = new MovieItem(7, "film6", ACTION);
    private final MovieItem eighth = new MovieItem(8, "film7", THRILLER);
    private final MovieItem ninth = new MovieItem(9, "film8", CARTOON);
    private final MovieItem tenth = new MovieItem(10, "film9", COMEDY);
    private final MovieItem eleventh = new MovieItem(11, "film10", ACTION);

    @Test
    public void shouldAddWithoutLimitWhenZero() {
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithoutLimitWhenOne() {
        manager.add(first);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithoutLimitWhenTwo() {
        manager.add(first);
        manager.add(second);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithoutLimitWhenNine() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithoutLimitWhenTen() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithoutLimitWhenEleven() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }
}




