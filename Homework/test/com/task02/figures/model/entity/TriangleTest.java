package com.task02.figures.model.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {

    private Triangle r1;
    private Triangle r2;
    private Triangle r3;

    @BeforeEach
    public void init() {
        r1 = new Triangle("white", 10, 10);
        r2 = new Triangle("white", 10, 10);
        r3 = new Triangle("black", 20, 20);
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
        assertEquals(r1.getA() / 2 * r1.getH(), r1.calcArea());
    }

    @AfterEach
    public void afterTesting() {
        r1 = r2 = r3 = null;
    }
}
