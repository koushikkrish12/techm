package com.git.app;
import java.util.*;

class OddNumbersThread extends Thread{
  private int n;

     public OddNumbersThread(int n) {
         super("Odd Numbers");
         this.n = n;
     }

     @Override
     public void run() {
         System.out.println("Odd Numbers Thread:");
         for (int i = 1, count = 0; count < n; i += 2, count++) {
             System.out.print(i + " ");
         }
         System.out.println();
     }
}

class ReverseThread extends Thread {
    private int n;

    public ReverseThread(int n) {
        super("Reverse");
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Reverse Thread:");
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class GitHub {
 public static void main(String []args) {
  
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the no:");
  int n=sc.nextInt();
  
  OddNumbersThread oddthread= new OddNumbersThread(n);
  ReverseThread reversethread = new ReverseThread(n);
  
  oddthread.start();
  reversethread.start();
  
  try {
   oddthread.join();
            reversethread.join();
  }catch (InterruptedException e) {
            e.printStackTrace();
  }
  
 }
}