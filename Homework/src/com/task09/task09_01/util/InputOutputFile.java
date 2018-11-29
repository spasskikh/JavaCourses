package com.task09.task09_01.util;

import com.task09.task09_01.model.data.DataSource;
import com.task09.task09_01.model.entity.Book;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;

public class InputOutputFile {
    private final static Logger logger = Logger.getLogger(InputOutputFile.class);

    static {
        PropertyConfigurator.configure("./Homework/resources/task09_01/log4j.properties");
    }

    private static File file = new File("./Homework/src/com/task09/task09_01/model/data/data.ser");

    public static Book[] load() {
        try (ObjectInput oi = new ObjectInputStream(new FileInputStream(file))) {
            return (Book[]) oi.readObject();
        } catch (FileNotFoundException exp) {
            logger.info("File not found!");
            return DataSource.getBooks();
        } catch (IOException | ClassNotFoundException exp) {
            logger.error("Error i/o");
            return new Book[0];
        }
    }

    public static void save(Book[] books) {
        try (ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(file))) {
            oo.writeObject(books);
        } catch (FileNotFoundException exp) {
            logger.info("File not found");
        } catch (IOException exp) {
            logger.error("Data not saved");
        }
    }


}
