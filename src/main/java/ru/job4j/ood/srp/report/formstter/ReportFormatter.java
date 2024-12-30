package ru.job4j.ood.srp.report.formstter;

import ru.job4j.ood.srp.model.Employee;

import java.util.List;

public interface ReportFormatter {
    String format(List<Employee> employees);
}