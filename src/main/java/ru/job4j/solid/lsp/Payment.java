package ru.job4j.solid.lsp;

/*
Базовый класс Payment принимает любые положительные суммы. Подкласс CreditCardPayment усиливает предусловие,
требуя минимальную сумму $100, что нарушает LSP.
 */
class Payment {
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        System.out.println("Processing payment of $" + amount);
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        if (amount < 100) {
            throw new IllegalArgumentException("Credit card payments must be at least $100");
        }
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class Example3 {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        payment.processPayment(50);
    }
}
