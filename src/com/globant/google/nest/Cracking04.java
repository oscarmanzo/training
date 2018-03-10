package com.globant.google.nest;

/**
 * 1.4 Write a method to decide if two strings are anagrams or not.
 * O(n^2): recorrido de caracteres adicional un ciclo que vuelve a evaluar todos los caracteres
 **/
public class Cracking04 {

    public static void main(String[] args){
        Cracking04 app = new Cracking04();
        System.out.println(app.areAnagram("arc", "car"));
        System.out.println(app.areAnagram("abc", "bcd"));
    }

    public boolean areAnagram(String word01, String word02){
        boolean result = true;
        
        char[] chars01 = word01.toCharArray();
        char[] chars02 = word02.toCharArray();
        
        if (chars01.length != chars02.length) return false;
        
        for (int i=0; i<chars01.length - 1; i++){
            char c = chars01[i];
            
            int index = findChar(c, chars02);
            
            if (index==-1){
                result = false;
                break;
            }
        }
        
        return result;
    }

    private int findChar(char c, char[] chars){
        int result = -1;

        for (int i=0; i<chars.length; i++){
            if (c == chars[i]){
                result = i;
                break;
            }
        }

        return result;
    }

}
