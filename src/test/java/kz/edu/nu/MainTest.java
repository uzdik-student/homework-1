package kz.edu.nu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void add() {
        Main main = new Main();
        int total = main.add(1, 2);
        assertEquals(150, total, "Balance should be 150 after depositing 50");
    }
}