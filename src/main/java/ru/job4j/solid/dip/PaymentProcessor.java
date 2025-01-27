package ru.job4j.solid.dip;

class PaymentProcessor {
    public void processPayment() {
        System.out.println("Processing payment");
    }
}

/*
ECommercePlatform зависит от конкретного класса PaymentProcessor. Это делает систему сложной для расширения,
так как для добавления нового способа оплаты нужно менять ECommercePlatform.
 */

class ECommercePlatform {
    private PaymentProcessor paymentProcessor;

    public ECommercePlatform() {
        paymentProcessor = new PaymentProcessor();
    }

    public void checkout() {
        paymentProcessor.processPayment();
    }
}
