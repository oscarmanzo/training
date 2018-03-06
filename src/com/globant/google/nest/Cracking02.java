package com.globant.google.nest;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Cracking02 {
    
    public static void main(String[] args) {
	    Cracking02 app = new Cracking02();
	    
	    byte[] cStyle = app.toCstyle("oscar");
	    System.out.println(Arrays.toString(cStyle));
    }
    
    public byte[] toCstyle(String value){
        byte[] bytes = value.getBytes(StandardCharsets.US_ASCII);
        return bytes;
    }
}
