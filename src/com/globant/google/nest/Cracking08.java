package com.globant.google.nest;

/**
 * 1.8 Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
 * O(n) * O(n-i) => O(n)
 **/
public class Cracking08 {
    
    public static void main(String[] args){
        Cracking08 app = new Cracking08();
        
        String s1 = "Oscar Manzo Camacho";
        String s2 = "Manzo";
        System.out.println("isSubstring: "+ s1 +", "+ s2 +": "+ app.isSubstring(s1, s2));
        
        s1 = "waterbottle";
        s2 = "erbottlewat";
        System.out.println("isRotation: "+ s1 +", "+ s2 +": "+ app.isRotation(s1, s2));
    }
    
    public boolean isRotation(String s1, String s2){
        boolean is = isSubstring((s2 + s2), s1);
        return is;
    }
    
    public boolean isSubstring(String s1, String s2){
        boolean is = false;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        
        for (int i=0; i<chars1.length; i++){
            if (chars1[i] == chars2[0]){
                is = find(chars1, i, chars2);
                
                if (is) break;
            }
        }
        
        return is;
    }
    
    private boolean find(char[] chars1, int index1, char[] chars2){
        boolean result = true;
        
        if ((chars1.length - index1) < chars2.length) return false;
        
        for (int i=index1, j = 0; i<chars1.length && j<chars2.length; i++, j++){
            if (chars1[i] != chars2[j]){
                result = false;
                break;
            }
        }

        return result;
    }
    
}
