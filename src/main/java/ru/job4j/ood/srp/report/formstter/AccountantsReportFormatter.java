package ru.job4j.ood.srp.report.formstter;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;

import java.util.Calendar;
import java.util.List;

public class AccountantsReportFormatter implements ReportFormatter {
    private final DateTimeParser<Calendar> dateTimeParser;
    private final CurrencyConverter converter;

    public AccountantsReportFormatter(DateTimeParser<Calendar> dateTimeParser, CurrencyConverter converter) {
        this.dateTimeParser = dateTimeParser;
        this.converter = converter;
    }

    @Override
    public String format(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        employees.forEach(employee -> text
                .append(employee.getName()).append(" ")
                .append(dateTimeParser.parse(employee.getHired())).append(" ")
                .append(dateTimeParser.parse(employee.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, employee.getSalary(), Currency.USD))
                .append(System.lineSeparator()));
        return text.toString();
    }
}
