package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.formstter.ReportFormatter;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class ReportEngine implements Report {
    private final Store store;
    private final ReportFormatter formatter;

    public ReportEngine(Store store, ReportFormatter formatter) {
        this.store = store;
        this.formatter = formatter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return formatter.format(store.findBy(filter));
    }
}
