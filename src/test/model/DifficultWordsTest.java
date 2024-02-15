package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifficultWordsTest {
    private DifficultWords dw1;
    private DifficultWords dw2;
    private DifficultWords dw3;
    private DifficultWords dw4;
    private DifficultWords dw5;

    @BeforeEach
    public void setUp()  {
        dw1 = new DifficultWords("abc");
        dw2 = new DifficultWords("HelloWorld");
        dw4 = new DifficultWords("GettingIntoComputerScience");
        dw5 = new DifficultWords("HelloWorldd");
        dw3 = new DifficultWords("abab");

    }

    @Test
    public void testConstructor() {
        assertEquals("abab", dw3.getSpelling());
        assertEquals(1, dw3.getLevel());
        assertFalse(dw3.getStatus());
        assertEquals("abab",dw3.getLeftToType());
    }

    @Test
    public void checkDifficultyVeryLong() {
        dw4.checkDifficulty();
        assertEquals(2, dw4.getLevel());
    }

    @Test
    public void checkDifficultyLong() {
        dw2.checkDifficulty();
        assertEquals(1, dw2.getLevel());
    }

    @Test
    public void checkDifficultyBarelyLong() {
        dw5.checkDifficulty();
        assertEquals(2, dw5.getLevel());
    }

    @Test
    public void checkDifficultyShort() {
        dw1.checkDifficulty();
        assertEquals(1, dw1.getLevel());

    }

}