package ru.job4j.algorithms;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        char[] numberCharArray = number.toCharArray();
        int right = numberCharArray.length - 1;
        boolean result = true;
        for (int left = 0; left < numberCharArray.length; left++) {
            if (numberCharArray[left] != numberCharArray[right]) {
                result = false;
                break;
            }
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
    }
}
