package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.formstter.ReportFormatter;
import ru.job4j.ood.srp.report.formstter.XmlReportFormatter;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class XmlReportEngineTest {
    @Test
    void whenGenerated() {
        Report report = getReport();
        String expect = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>John Doe</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>5000.0</salary>
                    </employee>
                    <employee>
                        <name>Jane Smith</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>6000.0</salary>
                    </employee>
                </employees>
                """;
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }

    @Test
    void whenNoEmployeesThenEmptyXml() {
        Store store = new MemoryStore();
        ReportFormatter formatter = new XmlReportFormatter();
        Report report = new ReportEngine(store, formatter);
        String expectedXml = """
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <employees/>
            """;
        assertThat(report.generate(em -> true)).isEqualTo(expectedXml);
    }

    @Test
    void whenSingleEmployeeThenGenerateXml() {
        Store store = new MemoryStore();
        ReportFormatter formatter = new XmlReportFormatter();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        store.add(employee);
        Report report = new ReportEngine(store, formatter);
        String expectedXml = """
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <employees>
                <employee>
                    <name>John Doe</name>
                    <hired>08:06:2023 17:41</hired>
                    <fired>08:06:2023 17:41</fired>
                    <salary>5000.0</salary>
                </employee>
            </employees>
            """;
        assertThat(report.generate(em -> true)).isEqualTo(expectedXml);
    }

    @Test
    void whenNullFieldsThenGenerateXml() {
        Store store = new MemoryStore();
        ReportFormatter formatter = new XmlReportFormatter();
        Employee employee = new Employee("John Doe", null, null, 5000.0);
        store.add(employee);
        Report report = new ReportEngine(store, formatter);
        String expectedXml = """
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <employees>
                <employee>
                    <name>John Doe</name>
                    <salary>5000.0</salary>
                </employee>
            </employees>
            """;
        assertThat(report.generate(em -> true)).isEqualTo(expectedXml);
    }

    private static Report getReport() {
        Store store = new MemoryStore();
        ReportFormatter formatter = new XmlReportFormatter();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        store.add(employee);
        store.add(employee1);
        return new ReportEngine(store, formatter);
    }
}
