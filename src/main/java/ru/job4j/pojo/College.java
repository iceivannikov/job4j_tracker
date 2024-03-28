package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Viktor Ivannikov");
        student.setGroup("Group #1");
        student.setReceiptDate(LocalDate.now());
        System.out.println(student.getName() + ", " + student.getGroup() + ", " + student.getReceiptDate());
    }
}
