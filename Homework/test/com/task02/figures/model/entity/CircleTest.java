package com.task02.figures.model.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    private Circle c1;
    private Circle c2;
    private Circle c3;

    @BeforeEach
    public void init() {
        c1 = new Circle("white", 10);
        c2 = new Circle("white", 10);
        c3 = new Circle("black", 20);
    }

    @Test
    public void testCircleEqualsCorrect() {
        assertTrue(c1.equals(c2));
    }

    @Test
    public void testCircleEqualsInCorrect() {
        assertFalse(c3.equals(c2));
    }

    @Test
    public void testCalcArea() {
        assertEquals(Math.PI * Math.pow(c1.getR(), 2), c1.calcArea());
    }

    @AfterEach
    public void afterTesting() {
        c1 = c2 = c3 = null;
    }

}
