package com.globant.google.nest;

public class ThreadApp01 {

    public static void main(String[] args){
        ThreadApp01 app = new ThreadApp01();
        app.execute();
    }

    public void execute(){
        Counter counter01 = new IncreaseCounter(100);
        Counter counter02 = new DecreaseCounter(100);

        counter01.start();
        counter02.start();
    }

}

abstract class Counter extends Thread {
    
    protected int limit;
    protected int count;
    
    public Counter(int limit){
        this.limit = limit;
    }
    
    public void run(){
        String nameThread = Thread.currentThread().getName();
        counter(nameThread);
    }

    public abstract void counter(String nameThread);

    protected void increment(){
        count++;
    }

    protected void decrement(){
        count--;
    }

}

class IncreaseCounter extends Counter {

    public IncreaseCounter(int limit){
        super(limit);
    }

    public void counter(String nameThread){
        count = 0;
        
        for (int i=0; i<limit; i++){
            increment();
            System.out.println(nameThread +" - count:"+ count);
        }
    }
    
}

class DecreaseCounter extends Counter {

    public DecreaseCounter(int limit){
        super(limit);
    }

    public synchronized void counter(String nameThread){
        count = limit;
        
        for (int i=limit; i>0; i--){
            decrement();
            System.out.println(nameThread +" - count:"+ count);
        }
    }
    
}
