package ru.job4j.solid.ocp;

/*
При добавлении нового способа оплаты нужно редактировать метод processPayment. Это усложняет
тестирование и увеличивает вероятность ошибок.
 */
public class PaymentProcessor {
    public void processPayment(String paymentType) {
        if ("CreditCard".equals(paymentType)) {
            System.out.println("Processing credit card payment...");
        } else if ("PayPal".equals(paymentType)) {
            System.out.println("Processing PayPal payment...");
        } else if ("Crypto".equals(paymentType)) {
            System.out.println("Processing cryptocurrency payment...");
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}
