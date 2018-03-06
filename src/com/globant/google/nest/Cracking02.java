package com.globant.google.nest;

public class Cracking02 {
    
    public static void main(String[] args) {
	    Cracking02 app = new Cracking02();
	    
	    char[] cstyle = app.toCStyleReverse("oscar");
	    System.out.println(String.valueOf(cstyle) +":"+ cstyle.length);
    }
    
    public char[] toCStyleReverse(String value){

        char[] chars = value.toCharArray();
        char[] charsNew = new char[chars.length + 1];
        
        for (int i=chars.length-1, j = 0; i>=0; i--, j++){
            charsNew[j] = chars[i];
        }
        
        charsNew[charsNew.length-1] = '\0';
        
        return charsNew;
    }
}
