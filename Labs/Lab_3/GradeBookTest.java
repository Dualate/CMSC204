import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradeBookTest {
    GradeBook book1;
    GradeBook book2;

    @Before
    public void setUp() throws Exception {
        book1 = new GradeBook(5);
        book2 = new GradeBook(5);
        book1.addScore(3.0);
        book1.addScore(9.0);
        book1.addScore(4.0);
        book1.addScore(2.0);

        book2.addScore(14.0);
        book2.addScore(22.0);
    }

    @After
    public void tearDown() throws Exception {
        book1 = book2 = null;
    }

    @Test
    public void addScore() {
        assertTrue(book1.toString().equals("3.0 9.0 4.0 2.0 0.0 "));
        assertTrue(book2.toString().equals("14.0 22.0 0.0 0.0 0.0 "));
    }

    @Test
    public void sum() {
        assertEquals(book1.sum(), 18.0, 0.0);
        assertEquals(book2.sum(), 36.0, 0.0);
    }

    @Test
    public void minimum() {
        assertEquals(book1.minimum(), 2.0, 0.0);
        assertEquals(book2.minimum(), 14.0, 0.0);
    }

    @Test
    public void finalScore() {
        assertEquals(book1.finalScore(), 16.0, 0.0);
        assertEquals(book2.finalScore(), 22.0, 0.0);
    }

    @Test
    public void getScoreSize() {
        assertEquals(4.0, book1.getScoreSize(), 0.0);
        assertEquals(2.0, book2.getScoreSize(), 0.0);
    }

    @Test
    public void testToString() {
    }
}