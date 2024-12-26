package ru.job4j.solid.srp;

import java.util.List;
/*
        Класс с несколькими обязанностями (обработка данных и вывод)
        Причина нарушения SRP:
        Класс одновременно отвечает за обработку данных (умножение на 2) и за их вывод. Если нужно изменить
        способ вывода (например, записывать данные в файл), придется модифицировать этот класс, что нарушает SRP.
 */
public class DataProcessor {
    public List<Integer> processData(List<Integer> data) {
        return data.stream().map(x -> x * 2).toList();
    }

    public void printData(List<Integer> data) {
        data.forEach(System.out::println);
    }
}
