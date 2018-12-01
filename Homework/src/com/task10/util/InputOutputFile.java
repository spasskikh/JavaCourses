package com.task10.util;

import com.task10.model.data.DataSource;
import com.task10.model.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputOutputFile {

    static {
        Path path = Paths.get("/home/anton/Documents/java/IdeaProjects/JavaCourses/Homework/resources/task10/log4j2.xml");
        System.setProperty("log4j.configurationFile", path.toString());
    }

    private final static Logger logger = LogManager.getLogger(InputOutputFile.class);

    private static File file = new File("./Homework/src/com/task10/model/data/data.ser");

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
