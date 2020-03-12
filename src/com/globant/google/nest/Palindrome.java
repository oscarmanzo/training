package com.globant.google.nest;

import java.util.Arrays;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome app = new Palindrome();

        Arrays.stream(app.getWords())
                .forEach(
                        s -> System.out.println(s +" is palindrome? "+ app.isPalindrome(s))
                );
    }

    private boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int i = 0, j = word.length() - 1;

        while (i < j){
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    private String[] getWords() {
        return new String[]{
                "Acrobatsstaborca",
                "oscar",
                "Aeratepetarea",
                "Ana",
                "rocio",
                "Animallootsfoliateddetailofstoollamina",
                "Anna",
                "penelope"
        };
    }

}
