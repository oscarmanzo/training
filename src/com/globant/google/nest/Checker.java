package com.globant.google.nest;

public class Checker {

    public static void main(String[] args){
        Checker app = new Checker();
        app.execute();
    }

    public void execute(){
        int combinations = sumCheck(new int[]{1,2,3,4,5,7,9, 10}, 8);
        System.out.println(combinations);
    }

    public int sumCheck(int[] arr, int total) {
        int result = 0;

        for (int i=0; i < arr.length; i++){

            if (arr[i] > total) continue;

            for (int j = i + 1; j < arr.length; j++){

                if (arr[j] > total) continue;

                if (arr[i] + arr[j] == total) {
                    System.out.println(arr[i] +" "+ arr[j]);
                    result++;
                }
            }
        }
    
        return result;
    }

}
