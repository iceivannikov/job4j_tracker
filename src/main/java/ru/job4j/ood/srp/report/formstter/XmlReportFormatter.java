package ru.job4j.ood.srp.report.formstter;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.job4j.ood.srp.formatter.CalendarAdapter;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class XmlReportFormatter implements ReportFormatter {

    @Override
    public String format(List<Employee> employees) {
        String xml;
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class, Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setAdapter(CalendarAdapter.class, new CalendarAdapter(new ReportDateTimeParser()));
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Employees wrappedEmployees = new Employees(employees);
            marshaller.marshal(wrappedEmployees, writer);
            xml = writer.getBuffer().toString();
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("Error while generating XML", e);
        }
        return xml;
    }
}
