package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (isUserExist(user)) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (isUserExist(user)) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = null;
        if (isUserExist(user)) {
            accounts = getAccounts(user);
        }
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }

    private boolean isUserExist(User user) {
        return user != null;
    }
}
