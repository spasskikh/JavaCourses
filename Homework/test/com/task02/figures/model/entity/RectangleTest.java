package com.task02.figures.model.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangleTest {

    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;

    @BeforeEach
    public void init() {
        r1 = new Rectangle("white", 10, 10);
        r2 = new Rectangle("white", 10, 10);
        r3 = new Rectangle("black", 20, 20);
    }

    @Test
    public void testCircleEqualsCorrect() {
        assertTrue(r1.equals(r2));
    }

    @Test
    public void testCircleEqualsInCorrect() {
        assertFalse(r3.equals(r2));
    }

    @Test
    public void testCalcArea() {
        assertEquals(r1.getA() * r1.getB(), r1.calcArea());
    }

    @AfterEach
    public void afterTesting() {
        r1 = r2 = r3 = null;
    }
}
