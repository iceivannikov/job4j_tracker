package ru.job4j.solid.dip;

class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

/*
NotificationManager зависит от конкретного класса EmailService. Вместо того чтобы зависеть от
абстракции (например, интерфейса), он напрямую зависит от реализации.
 */

class NotificationManager {
    private EmailService emailService;

    public NotificationManager() {
        emailService = new EmailService();
    }

    public void notifyUser(String message) {
        emailService.sendEmail(message);
    }
}
