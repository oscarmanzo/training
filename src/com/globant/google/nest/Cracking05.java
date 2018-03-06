package com.globant.google.nest;

public class Cracking05 {

    private static final char CHAR_SPACE = ' ';
    private static final char[] chars_space = "%20".toCharArray();

    public static void main(String[] args){
        Cracking05 app = new Cracking05();
        System.out.println(app.replaceAllSpaces("Oscar Manzo Camacho"));
    }

    public String replaceAllSpaces1(String value){
        return value.replaceAll(" ","%20");
    }

    public String replaceAllSpaces(String value){
    
        char[] chars = value.toCharArray();

        int countSpaces = countSpaces(chars);

        char[] charsNew = new char[(countSpaces * 3) + chars.length];
    
        int j = 0;
        for (int i=0; i <chars.length; i++){

            char c = chars[i];

            if (c == CHAR_SPACE){
                charsNew[j++] = chars_space[0];
                charsNew[j++] = chars_space[1];
                charsNew[j++] = chars_space[2];
            } else {
                charsNew[j++] = c;
            }
        }    
    
        return String.valueOf(charsNew);
    }

    private int countSpaces(char[] chars){
        int count = 0;
        
        for (char c : chars)
            if (c == CHAR_SPACE) count++;

        return count;   
    }

}
