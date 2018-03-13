package com.globant.google.nest;

public class ThreadAppB {

    private int count;

    public static void main(String[] args){
        ThreadAppB app = new ThreadAppB();
        app.execute();
    }

    public void execute(){
        
        CounterUp counter1 = new CounterUp(this);
        CounterDown counter2 = new CounterDown(this);
        
        counter1.start();
        counter2.start();

    }

    public synchronized void increment(){
        count++;
    }

    public synchronized void decrement(){
        count--;
    }

    public synchronized int getCount(){
        return this.count;
    }

    public synchronized void setCount(int count){
        this.count = count;
    }

    // ++++++++++++++++++++++++++++++++++++++
    class CounterUp extends Thread {
        
        ThreadAppB app;

        public CounterUp(ThreadAppB app){
            this.app = app;
        }

        public void run() {
            this.app.setCount(0);
            
            for (int i=0; i<100; i++){
                this.app.increment();
                System.out.println(Thread.currentThread().getName() +" - count:"+ this.app.getCount());
            }            
        }
    }

    class CounterDown extends Thread {
        
        ThreadAppB app;

        public CounterDown(ThreadAppB app){
            this.app = app;
        }

        public void run() {
            this.app.setCount(100);
            
            for (int i=100; i>0; i--){
                System.out.println(Thread.currentThread().getName() +" - "+ this.app.getCount());
                this.app.decrement();
            }
        }
    }

}
