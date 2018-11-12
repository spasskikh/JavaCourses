package com.task07.task07_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Runner {

    public void run() throws Exception{
        Class<UnaryOperation> clazz = UnaryOperation.class;

        Constructor<UnaryOperation> constructor = clazz.getConstructor();

        UnaryOperation unaryOperation = constructor.newInstance();
        System.out.println(unaryOperation);

        for(Method m: clazz.getDeclaredMethods()) {
            if (m.getName().startsWith("set")) {
                m.invoke(unaryOperation, 200.0);
                break;
            }
        }
        System.out.println(unaryOperation);


        Method increment = clazz.getMethod("increment");
        increment.invoke(unaryOperation);
        System.out.println(unaryOperation);
    }
}
