package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет пользователя банка.
 * @author Viktor Ivannikov
 * @version 1.0
 */
public class User {
    /** Паспорт пользователя. */
    private String passport;

    /** Имя пользователя. */
    private String username;

    /**
     * Конструктор создает нового пользователя с указанным паспортом и именем.
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получить паспорт пользователя.
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Установить паспорт пользователя.
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получить имя пользователя.
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Установить имя пользователя.
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода сравнения на равенство.
     * Два пользователя считаются равными, если их паспорта совпадают.
     * @param o объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода вычисления хэш-кода.
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    /**
     * Переопределение метода преобразования объекта в строку.
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "User{"
                + "passport='" + passport + '\''
                + ", username='" + username + '\''
                + '}';
    }
}
