package com.task05.recordbook.service;

import com.task05.recordbook.model.RecordsModel;
import com.task05.recordbook.model.entity.Record;
import com.task05.recordbook.model.entity.data.DataSource;
import com.task05.recordbook.util.UserInput;
import com.task05.recordbook.util.Validator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

public class RecordsService {

    private RecordsModel model;
    private UserInput input;

    public RecordsService() {
        model = new RecordsModel();
        input = new UserInput();
    }

    public void initData() {
        model.setRecords(DataSource.get());
    }

    public int getSwitcher() {
        return input.getInt("Enter an action: ");
    }

    public List<Record> getAllRecords() {
        return model.getRecords();
    }

    public void addRecord() {
        input.nextLine();

        String surname = getData("Enter surname: ", Validator.name);
        String name = getData("Enter name: ", Validator.name);
        String phoneNumber = getData("Enter phone number: ", Validator.phone);

        LocalDate dateOfBirth = getDate();
        while (dateOfBirth == null) {
            dateOfBirth = getDate();
        }

        input.nextLine();
        String city = getData("Enter city: ", Validator.name);
        String street = getData("Enter street: ", Validator.name);
        int house = getNumber("Enter house number: ");
        int apartment = getNumber("Enter apartment number: ");

        Record record = model.createRecord(name, surname, "+38" + phoneNumber, dateOfBirth, city, street, house, apartment);
        model.addRecord(record);
    }

    private String getData(String message, Pattern p) {

        String data = input.getLine(message);

        while (!p.matcher(data).matches()) {
            System.out.println(data);
            data = input.getLine("Incorrect input. " + message);
        }
        return data;
    }

    private int getNumber(String message) {
        return input.getInt(message);
    }

    private LocalDate getDate() {
        int year, month, date;

        year = input.getInt("Enter year:");
        while (year < 1980 || year > 2005) {
            year = input.getInt("Enter year:");
        }

        month = input.getInt("Enter month:");
        while (month < 0 || month > 12) {
            month = input.getInt("Enter month:");
        }

        date = input.getInt("Enter date:");
        while (date < 0 || date > 31) {
            date = input.getInt("Enter date:");
        }

        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.of(year, month, date);
        } catch (DateTimeException ex) {
        }
        return dateOfBirth;
    }


}
