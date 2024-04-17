package ru.job4j.map;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> Objects.equals(student.account(), account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        return findByAccount(account)
                .flatMap(student -> students.get(student)
                        .stream()
                        .filter(subject -> Objects.equals(subject.name(), name))
                        .findFirst());
    }
}
