package ru.job4j.solid.isp;

public interface AdminActions {
    void manageUsers();

    void viewReports();

    void deleteDatabase();
}

/*
Класс ReportAdmin не использует методы manageUsers() и deleteDatabase(),
но вынужден их реализовывать, что нарушает принцип ISP.
 */

class ReportAdmin implements AdminActions {
    @Override
    public void manageUsers() {
    }

    @Override
    public void viewReports() {
        System.out.println("Viewing reports");
    }

    @Override
    public void deleteDatabase() {
    }
}