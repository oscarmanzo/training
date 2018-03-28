package com.globant.google.nest;

public final class SingletonThreadSafe {

    private static SingletonThreadSafe INSTANCE;

    private SingletonThreadSafe(){
    }

    public static final synchronized SingletonThreadSafe getInstance(){

        if (INSTANCE==null)
            INSTANCE = create();

        return INSTANCE;
    }

    private static SingletonThreadSafe create(){
        return new SingletonThreadSafe();
    }

    public static void main(String[] args){
        
        new Thread(){
            public void run(){
                System.out.println(SingletonThreadSafe.getInstance());
            }
        }.start();

        new Thread(){
            public void run(){
                System.out.println(SingletonThreadSafe.getInstance());
            }
        }.start();
        
    }

}