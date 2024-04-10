package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работы банковского сервиса
 * по переводу денежных средств.
 *
 * @author Viktor Ivannikov
 * @version 1.0
 */
public class BankService {
    /**
     * Содержит всех пользователей системы с
     * привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавить пользователя в систему.
     *
     * @param user пользователь, которого нужно добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удалить пользователя из системы по его паспорту.
     *
     * @param passport паспортные данные пользователя
     *                 по которым его нужно удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавить новый счет к пользователю
     *
     * @param passport паспортные данные пользователя
     *                 по которым его нужно найти.
     * @param account  банковский счет который нужно
     *                 добавить к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (isUserExist(user)) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Найти пользователя по номеру паспорта
     *
     * @param passport паспортные данные пользователя
     *                 по которым его нужно найти.
     * @return возвращает пользователя? если он существует и
     * null если такого пользователя нет
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Найти банковский счет пользователя по реквизитам
     *
     * @param passport  паспортные данные пользователя
     * @param requisite реквизиты банковского счета
     * @return возвращает банковский счет пользователя, если он существует и
     * null если такого счета нет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (isUserExist(user)) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Перечислить денежные средства.
     *
     * @param sourcePassport       паспортные данные пользователя со счета которого
     *                             денежные средства будут списаны
     * @param sourceRequisite      реквизиты банковского счета с которого
     *                             будут списаны денежные средства
     * @param destinationPassport  паспортные данные пользователя на счет которого
     *                             денежные средства будут зачислены
     * @param destinationRequisite реквизиты банковского счета на который
     *                             будут зачислены денежные средства
     * @param amount               сумма, которая будет переведена
     * @return true в случае удачной транзакции, и false в случае неудачной транзакции.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null || sourceAccount.getBalance() < amount || destinationAccount == null) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;
    }

    /**
     * Получить все счета определенного пользователя.
     *
     * @param user пользователь, список счетов которого нужно получить.
     * @return возвращает список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }

    /**
     * Определить равняется пользователь null или нет
     *
     * @param user пользователь которого нужно проверить.
     * @return возвращает true если пользователь не null, и false если пользователь null
     */
    private boolean isUserExist(User user) {
        return user != null;
    }
}
