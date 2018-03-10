package com.globant.google.nest;

/**
 * 1.3 Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * O(n): Recorrido de caracteres, con ciclo interno pero decremento de contador
 **/
public class Cracking03 {

    private static final char DEFAULT = '\u0000';
    
    public static void main(String[] args){
        Cracking03 app = new Cracking03();
        System.out.println(app.removeDuplicates("aaabbbccc"));
    }
    
    public String removeDuplicates(String value){

        
        char[] chars = value.toCharArray();
        
        for (int i=0; i<chars.length - 1; i++){
            char c = chars[i];

            if (c == DEFAULT) continue;
            
            int index = 0;
            do{
                index = findReplaceChar(c, chars, i+1);
            } while (index >= 0);

        } 
        
        return String.valueOf(chars);
    }
    
    private int findReplaceChar(char c, char[] chars, int index){
        int result = -1;

        for (int i=index; i<chars.length; i++){
            if (c == chars[i]){
                result = i;
                chars[i] = DEFAULT;
                break;
            }
        }

        return result;
    }
    
}
