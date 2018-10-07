package com.javacourses.task01.transform;

import com.javacourses.task01.transform.controller.Transformer;
import com.javacourses.task01.transform.model.ValueToTransfom;
import com.javacourses.task01.transform.view.Viewer;

public class TransformMain {

    public static void main(String[] args) {

        int i = ValueToTransfom.generate();

        Viewer.print("Initial value: " + i);
        Viewer.print("Binary number: " + Transformer.binary(i));
        Viewer.print("Octal number: " + Transformer.octal(i));
        Viewer.print("Hexadecimal number: " + Transformer.hexadecimal(i));



    }

}
