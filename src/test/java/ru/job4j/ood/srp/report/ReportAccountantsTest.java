package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.formstter.AccountantsReportFormatter;
import ru.job4j.ood.srp.report.formstter.ReportFormatter;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReportAccountantsTest {
    @Test
    void creatingReportAccountantsDepartment() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        ReportFormatter formatter = new AccountantsReportFormatter(parser, converter);
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Viktor", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report report = new ReportEngine(store, formatter);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(parser.parse(worker1.getHired())).append(" ")
                .append(parser.parse(worker1.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker1.getSalary(), Currency.USD))
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(parser.parse(worker2.getHired())).append(" ")
                .append(parser.parse(worker2.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker2.getSalary(), Currency.USD))
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
