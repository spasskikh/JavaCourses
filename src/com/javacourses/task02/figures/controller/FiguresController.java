package com.javacourses.task02.figures.controller;

import com.javacourses.task02.figures.model.ShapesModel;
import com.javacourses.task02.figures.model.data.DataSource;
import com.javacourses.task02.figures.model.entity.Circle;
import com.javacourses.task02.figures.model.entity.Rectangle;
import com.javacourses.task02.figures.model.entity.Shape;
import com.javacourses.task02.figures.model.entity.Triangle;
import com.javacourses.task02.figures.util.UserInput;
import com.javacourses.task02.figures.view.Viewer;

import java.util.Arrays;
import java.util.Comparator;

public class FiguresController {

    private ShapesModel model = new ShapesModel();
    private Viewer viewer = new Viewer();
    private UserInput input = new UserInput();

    public void run() {
        model.setShapes(DataSource.get());
        model.drawFigure();

        viewer.printMenu();

        int switcher = input.getInt();
        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    viewer.printShapes("ALL FIGURES", model.getShapes());
                    switcher = input.getInt();
                    break;
                case 2:
                    totalArea();
                    switcher = input.getInt();
                    break;
                case 3:
                    figureArea();
                    switcher = input.getInt();
                    break;
                case 4:
                    sortByArea();
                    switcher = input.getInt();
                    break;
                case 5:
                    sortByColor();
                    switcher = input.getInt();
                    break;
                default:
                    viewer.printMessage("Incorrect parameter.");
                    viewer.printMenu();
                    switcher = input.getInt();
                    break;
            }
        }
    }

    private void totalArea() {
        double totalArea = model.getTotalArea();
        viewer.printMessage("Total shape of all figures: " + String.format("%.2f", totalArea));
    }

    private void figureArea() {

        viewer.printMessage("Please choose a figure: \n1 - Circle\n2 - Rectangle\n3 - Triangle");

        int figure = input.getInt();

        switch (figure) {
            case 1:
                viewer.printMessage("Total area for all circles: "
                        + String.format("%.2f", model.getFigureArea(new Circle())));
                break;
            case 2:
                viewer.printMessage("Total area for all rectangles: "
                        + String.format("%.2f", model.getFigureArea(new Rectangle())));
                break;
            case 3:
                viewer.printMessage("Total area for all triangles: "
                        + String.format("%.2f", model.getFigureArea(new Triangle())));
                break;
            default:
                viewer.printMessage("Incorrect parameter.");
                viewer.printMenu();
                break;
        }
    }

    private void sortByArea() {
        Shape[] shapes = model.getShapes();

        Arrays.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return (int)(s1.calcArea()-s2.calcArea());
            }
        });
        viewer.printShapes("Sorted by area:", shapes);

    }

    private void sortByColor() {
        Shape[] shapes = model.getShapes();

        Arrays.sort(shapes, (s1,s2) -> s1.getShapeColor().compareTo(s2.getShapeColor()));

        viewer.printShapes("Sorted by color:", shapes);
    }
}
