package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет собой банковский счет.
 * @author Viktor Ivannikov
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета.
     */
    private String requisite;
    /**
     * Баланс счета.
     */
    private double balance;

    /**
     * Конструктор создает новый банковский счет с указанными реквизитами и начальным балансом.
     * @param requisite реквизиты счета.
     * @param balance начальный баланс счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получить реквизиты счета
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Установить реквизиты счета
     * @param requisite реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получить текущий баланс счета
     * @return текущий баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Установить баланс счета
     * @param balance баланс который нужно установить
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода сравнения на равенство.
     * Два счёта считаются равными когда их реквизиты равны.
     * @param o объект для сравнивания
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода вычисления хэш-кода.
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    /**
     * Переопределение метода преобразования объекта в строку.
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "Account{"
                + "requisite='" + requisite + '\''
                + ", balance=" + balance
                + '}';
    }
}
