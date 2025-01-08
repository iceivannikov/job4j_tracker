package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.formstter.JsonReportFormatter;
import ru.job4j.ood.srp.report.formstter.ReportFormatter;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonReportEngineTest {
    @Test
    void whenAccountantsGenerated() {
        Report engine = getReport();
        String ex = """
                [
                  {
                    "name": "John Doe",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 5000.0
                  },
                  {
                    "name": "Jane Smith",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 6000.0
                  }
                ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(ex);
    }

    private static Report getReport() {
        Store store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportFormatter formatter = new JsonReportFormatter(parser);
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000);
        store.add(employee);
        store.add(employee1);
        return new ReportEngine(store, formatter);
    }

    @Test
    void whenNoEmployeesThenJsonIsEmptyArray() {
        Store store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportFormatter formatter = new JsonReportFormatter(parser);
        Report engine = new ReportEngine(store, formatter);
        String actualJson = engine.generate(em -> true);
        String expectedJson = "[]";
        assertThat(actualJson).isEqualTo(expectedJson);
    }
}
