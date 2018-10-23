package com.task02.figures.model;

import com.task02.figures.model.entity.Rectangle;
import com.task02.figures.model.entity.Shape;
import com.task02.figures.model.entity.Triangle;
import com.task02.figures.util.AreaComparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ShapesModelTest {

    private ShapesModel model;
    private Triangle t;
    private Rectangle r;

    @BeforeEach
    public void init() {
        t = new Triangle("white", 10, 10);
        r = new Rectangle("black", 10, 10);
        model = new ShapesModel();
        model.setShapes(new Shape[]{t, r});
    }

    @Test
    public void testGetTotalArea() {
        double res = t.calcArea() + r.calcArea();
        assertEquals(res, model.getTotalArea());
    }

    @ParameterizedTest(name = "{index} => shape={0}, area={1}")
    @CsvSource({
            "Triangle, 50",
            "Rectangle, 100"
    })
    public void testGetFigureArea(String shape, int area) {
        assertEquals(area, model.getFigureArea(shape));
    }

    @Test
    public void testSort() {
        model.sort(new AreaComparator());
        assertFalse(r.equals(model.getShapes()[0]));
    }

    @AfterEach
    public void afterTesting() {
        model = null;
        t = null;
        r = null;
    }
}
