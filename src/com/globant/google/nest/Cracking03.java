package com.globant.google.nest;

public class Cracking03 {
    
    public static void main(String[] args){
        Cracking03 app = new Cracking03();
        System.out.println(app.removeDuplicates("aabbcc"));
    }
    
    public String removeDuplicates(String value){
        char DEFAULT = '\u0000';
        
        char[] chars = value.toCharArray();
        
        for (int i=0; i<chars.length - 1; i++){
            char c = chars[i];
            
            if (c == DEFAULT) continue;
            
            int index = findChar(c, chars, i+1);
            
            if (index>=0){
                chars[index] = DEFAULT;
            }
        } 
        
        return String.valueOf(chars);
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
