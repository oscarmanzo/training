package com.globant.google.nest;

public class Cracking01 {
    
    public static void main(String[] args) {
	    Cracking01 app = new Cracking01();
	    System.out.println(app.uniqueCharacters("oscar"));	    
    }

    /**
     * 1.1 Implement an algorithm to determine if a string has all unique characters.
     * What if you can not use additional data structures?
     **/
    public boolean uniqueCharacters(String value){
        boolean unique = true;
        
        char[] chars = value.toCharArray();

        for (int i=0; i<chars.length - 1; i++){
            
            char c = chars[i];
            
            int nextIndex = findChar(c, chars, i+1);
            
            if (nextIndex>=0){
                unique = false;
                break;
            }
        }        
        
        return unique;
    }
    
    private int findChar(char c, char[] chars, int index){
        int result = -1;

        for (int i=index; i<chars.length; i++){
            if (c == chars[i]){
                result = i;
                break;
            }
        }

        return result;
    }

}
