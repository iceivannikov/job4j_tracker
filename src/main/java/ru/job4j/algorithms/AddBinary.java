package ru.job4j.algorithms;

public class AddBinary {
    public String addBinary(String a, String b) {
        int abs = Math.abs(a.length() - b.length());
        String stringZero = "0".repeat(abs);
        if (a.length() < b.length()) {
            a = stringZero + a;
        }
        if (b.length() < a.length()) {
            b = stringZero + b;
        }
        StringBuilder result = new StringBuilder();
        int transfer = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int bit1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            int bit2 = Integer.parseInt(String.valueOf(b.charAt(i)));
            int sum = bit1 + bit2 + transfer;
            if (sum == 0) {
                result.append('0');
                transfer = 0;
            } else if (sum == 1) {
                result.append('1');
                transfer = 0;
            } else if (sum == 2) {
                result.append('0');
                transfer = 1;
            }  else if (sum == 3) {
                result.append('1');
                transfer = 1;
            }
        }
        if (transfer ==  1) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String string = addBinary.addBinary("11", "1");
        System.out.println(string);
    }
}

