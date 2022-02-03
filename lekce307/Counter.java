/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce307;

/**
 *
 * @author 2019-e-edlund
 */
public class Counter extends Thread {
     private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        System.out.println("starting");
        c.start();
        System.out.println("waiting");
        c.join();
        System.out.println(counter);
        
    }
   

    @Override
    public void run() {
       for ( int i = 0; i  < 1_000_000_000; i++){
           counter++;
       }
    }
    
    
    
    
}
