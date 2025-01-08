package ru.job4j.ood.srp.report.formstter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.EmployeeSerializer;
import ru.job4j.ood.srp.model.Employee;

import java.util.Calendar;
import java.util.List;

public class JsonReportFormatter implements ReportFormatter {
    private final DateTimeParser<Calendar> dateTimeParser;

    public JsonReportFormatter(DateTimeParser<Calendar> dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String format(List<Employee> employees) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Employee.class, new EmployeeSerializer(dateTimeParser))
                .create();
        return gson.toJson(employees);
    }
}
