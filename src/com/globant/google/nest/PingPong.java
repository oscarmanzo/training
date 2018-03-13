package com.globant.google.nest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class PingPong {

    public static void main(String[] args){
        PingPong app = new PingPong();
        app.execute();        
    }

    public void execute(){
        try {
            Ball ball = new Ball();
            Player playerA = new Player("Player A", ball);
            Thread.sleep(500);
            Player playerB = new Player("Player B", ball);
    
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.execute(playerA);
            executor.execute(playerB);        
            executor.shutdown();
        
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis() - start < 3000){}
    
            System.out.println("Game over..!!!");
            System.exit(0);

        }catch(Exception e){
            e.printStackTrace();            
        }
    }
}

class Player implements Runnable {
    private static Random generator = new Random();

    private String name;
    private Ball ball;

    public Player(String name, Ball ball){
        this.name = name;
        this.ball = ball;
    }

    public void run(){
        try {
            while (true){
                this.hit(this.ball);
                Thread.sleep(generator.nextInt(500));
            }
        } catch(InterruptedException e){
            System.out.println("Game over.!!!");
        }
    }
    
    public void hit(Ball ball){
        synchronized(ball){
            try {
                ball.notify();

                System.out.println(getName() + " hit-> "+ ball.getName());

                ball.wait();
            } catch(InterruptedException e){
                System.out.println("Game over.!!!");
            }
        }
    }
    
    public String getName(){
        return this.name;
    }
}

class Ball {
    public String getName(){
        return "ball";
    }
}
