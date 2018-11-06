package com.task05.recordbook.model.entity.data;

import com.task05.recordbook.model.entity.Adress;
import com.task05.recordbook.model.entity.Record;
import com.task05.recordbook.model.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {

    public static List<Record> get() {
        return new ArrayList<>(
                Arrays.asList(
                        new Record(
                                new Student("Ivanov", "Ivan", LocalDate.of(1998, 2, 11), "+38(050)123-45-67",
                                        new Adress("Kiev", "South", 13, 18))
                        ),
                        new Record(
                                new Student("Petrov", "Petr", LocalDate.of(1999, 4, 27), "+38(050)234-56-78",
                                        new Adress("Lvov", "East", 35, 178))
                        ),
                        new Record(
                                new Student("Maksimov", "Maksim", LocalDate.of(2000, 6, 5), "+38(050)345-67-89",
                                        new Adress("Odessa", "West", 100, 16))
                        ),
                        new Record(
                                new Student("Pavlov", "Pavel", LocalDate.of(1995, 9, 14), "+38(050)456-78-90",
                                        new Adress("Kharkov", "North", 8, 23))
                        )
                ));
    }
}
