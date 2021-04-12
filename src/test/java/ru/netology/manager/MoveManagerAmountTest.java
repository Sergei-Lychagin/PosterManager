package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.domain.Genre.*;


public class MoveManagerAmountTest {

        MovieManager manager = new MovieManager(3);

        private final MovieItem first = new MovieItem(1, "film", CARTOON);
        private final MovieItem second = new MovieItem(2, "film1", COMEDY);
        private final MovieItem third = new MovieItem(3, "film2", ACTION);
        private final MovieItem fourth = new MovieItem(4, "film2", THRILLER);


        @Test
        public void shouldAddWithtLimitWhenZero() {
            MovieItem[] actual = manager.getAll();
            MovieItem[] expected = new MovieItem[]{};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldAddWithtLimitWhenOne() {
            manager.add(first);

            MovieItem[] actual = manager.getAll();
            MovieItem[] expected = new MovieItem[]{first};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldAddWithtLimitWhenTwo() {
            manager.add(first);
            manager.add(second);

            MovieItem[] actual = manager.getAll();
            MovieItem[] expected = new MovieItem[]{second,first};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldAddWithtLimitWhenThree() {
            manager.add(first);
            manager.add(second);
            manager.add(third);

            MovieItem[] actual = manager.getAll();
            MovieItem[] expected = new MovieItem[]{third,second,first};

            assertArrayEquals(expected, actual);
        }
    @Test
    public void shouldAddWithtLimitWhenFourth() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{fourth,third,second};

        assertArrayEquals(expected, actual);
    }
}
