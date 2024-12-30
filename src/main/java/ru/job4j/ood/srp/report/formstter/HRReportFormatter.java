package ru.job4j.ood.srp.report.formstter;

import ru.job4j.ood.srp.model.Employee;

import java.util.List;

public class HRReportFormatter implements ReportFormatter {

    @Override
    public String format(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> text.append(employee.getName()).append(" ")
                        .append(employee.getSalary()).append(System.lineSeparator()));
        return text.toString();
    }
}
