package com.task05.recordbook.model;

import com.task05.recordbook.model.entity.Adress;
import com.task05.recordbook.model.entity.Record;
import com.task05.recordbook.model.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecordsModel {

    private List<Record> records;

    public RecordsModel() {
        this.records = new ArrayList<>();
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Record createRecord(String surname, String name, String phonenumber, LocalDate dateOfBirth,
                               String city, String street, int house, int app) {
        return new Record(new Student(surname, name, dateOfBirth, phonenumber, new Adress(city, street, house, app)));
    }

    public void addRecord(Record record) {
        records.add(record);
    }
}
