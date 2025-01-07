package ru.job4j.solid.ocp;

/*
Каждый раз при добавлении нового типа отчёта нужно изменять метод generate, добавляя новый if или else if.
Это нарушение OCP, потому что класс не открыт для расширения (новый отчёт) без модификации существующего кода.
 */
public class ReportEngine {
    public String generate(String reportType) {
        if ("HR".equals(reportType)) {
            return "Generating HR report...";
        } else if ("Accounting".equals(reportType)) {
            return "Generating Accounting report...";
        } else if ("Programmers".equals(reportType)) {
            return "Generating Programmers report...";
        } else {
            throw new IllegalArgumentException("Unknown report type");
        }
    }
}
