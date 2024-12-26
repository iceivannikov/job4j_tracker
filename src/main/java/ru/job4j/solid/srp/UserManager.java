package ru.job4j.solid.srp;

/*
    Класс, который управляет и пользователями, и их хранением
    Причина нарушения SRP:
    Класс отвечает за две задачи: управление пользователями (логирование добавления) и их сохранение в базу данных.
    Это разные обязанности, которые стоит разделить.
 */
public class UserManager {
    public void addUser(String name) {
        System.out.println("User added: " + name);
    }

    public void saveUserToDatabase(String name) {
        System.out.println("Saving user to database: " + name);
    }
}
