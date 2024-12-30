package ru.job4j.ood.srp.report.formstter;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;

import java.util.Calendar;
import java.util.List;

public class ProgrammersReportFormatter implements ReportFormatter {
    private final DateTimeParser<Calendar> parser;

    public ProgrammersReportFormatter(DateTimeParser<Calendar> parser) {
        this.parser = parser;
    }

    @Override
    public String format(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator());
        employees.forEach(employee -> text
                .append(employee.getName()).append(",")
                .append(parser.parse(employee.getHired())).append(",")
                .append(parser.parse(employee.getFired())).append(",")
                .append(employee.getSalary())
                .append(System.lineSeparator()));
        return text.toString();
    }
}
