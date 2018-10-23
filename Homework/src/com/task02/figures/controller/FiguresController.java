package com.task02.figures.controller;

import com.task02.figures.model.ShapesModel;
import com.task02.figures.model.data.DataSource;
import com.task02.figures.model.entity.Shape;
import com.task02.figures.util.AreaComparator;
import com.task02.figures.util.ColorComparator;
import com.task02.figures.util.UserInput;
import com.task02.figures.view.Viewer;

import java.util.Arrays;
import java.util.Comparator;

public class FiguresController {

    private ShapesModel model = new ShapesModel();
    private Viewer viewer = new Viewer();
    private UserInput input = new UserInput();

    public void run() {
        model.setShapes(DataSource.get());

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
                        + String.format("%.2f", model.getFigureArea("Circle")));
                break;
            case 2:
                viewer.printMessage("Total area for all rectangles: "
                        + String.format("%.2f", model.getFigureArea("Rectangle")));
                break;
            case 3:
                viewer.printMessage("Total area for all triangles: "
                        + String.format("%.2f", model.getFigureArea("Triangle")));
                break;
            default:
                viewer.printMessage("Incorrect parameter.");
                viewer.printMenu();
                break;
        }
    }

    private void sortByArea() {
        model.sort(new AreaComparator());
        viewer.printShapes("Sorted by area:", model.getShapes());

    }

    private void sortByColor() {
        model.sort(new ColorComparator());
        viewer.printShapes("Sorted by color:", model.getShapes());
    }
}
