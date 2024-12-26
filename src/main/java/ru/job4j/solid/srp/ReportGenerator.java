package ru.job4j.solid.srp;

/*
    Генерация отчета и его форматирование в одном классе
    Класс выполняет две задачи: генерирует данные отчета и форматирует их. Если поменяется формат (например,
    нужно экспортировать в PDF), придется менять этот класс. Форматирование лучше вынести в отдельный класс.
 */
public class ReportGenerator {
    public String generateReport() {
        return "Report data";
    }

    public String formatReport(String report) {
        return "Formatted: " + report;
    }
}
