package com.example.scvdemo.engines;

import com.example.scvdemo.model.User;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CSVSaver {
    public static void saveUsers(List<User> users, PrintWriter writer) throws IOException {
//        String csvFileName = "users.csv";

//        response.setContentType("text/csv");
//
//        // creates mock data
//        String headerKey = "Content-Disposition";
//        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
//        response.setHeader(headerKey, headerValue);

//        List<User> users = userService.getAll();

        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);

//        String[] header = {"id", "name"};
        String[] header = Arrays.stream(User.class.getDeclaredFields()).map(Field::getName).toArray(String[]::new);

        csvWriter.writeHeader(header);

        for (User user : users) {
            csvWriter.write(user, header);
        }

        csvWriter.close();
    }
}
