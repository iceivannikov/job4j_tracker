package ru.job4j.ood.srp.formatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.job4j.ood.srp.model.Employee;

import java.lang.reflect.Type;
import java.util.Calendar;

public class EmployeeSerializer implements JsonSerializer<Employee> {
    private final DateTimeParser<Calendar> dateTimeParser;

    public EmployeeSerializer(DateTimeParser<Calendar> dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", employee.getName());
        jsonObject.addProperty("hired", dateTimeParser.parse(employee.getHired()));
        jsonObject.addProperty("fired", dateTimeParser.parse(employee.getFired()));
        jsonObject.addProperty("salary", employee.getSalary());
        return jsonObject;
    }
}
