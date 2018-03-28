package com.globant.google.nest;

import java.util.*;

public class TestCollections {

    public static void main(String[] args){
        TestCollections app = new TestCollections();
        app.testArrayList();
    }

    public void testArrayList(){
        String[] data = buildData();
        List<String> list = Arrays.asList(data);
        list.forEach(System.out::print);
    }

    private void add(List<String> list, String x){
        list.add(x);
    }

    private String get(List<String> list, int index){
        return list.get(index);
    }

    private String[] buildData(){
        String[] data = new String[122 - 96];
        
        int j = 0;
        for (int i=97; i<= 122; i++){
            data[j] = Character.toString((char)i);
            j++;
        }
        
        return data;
    }

}
