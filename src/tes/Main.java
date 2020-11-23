package tes;


import tes.classes.Parking;
import java.util.Scanner;

public class Main {
    static Parking parking;
    public static class Stats extends Thread{
        @Override
        public void run() {
            while (true) {
                parking.printStatistics();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Adder extends Thread{
        private final int sleepTime;
        public Adder(int sleepTime){
            this.sleepTime = sleepTime;
        }
        @Override
        public void run() {
            while (true) {
                parking.addCar();
                try {
                    Thread.sleep(sleepTime*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Remover extends Thread{
        private final int sleepTime;
        public Remover(int sleepTime){
            this.sleepTime = sleepTime;
        }
        @Override
        public void run() {
            while (true) {
                parking.removeCar();
                try {
                    Thread.sleep(sleepTime*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int queue = s.nextInt();
        int timeGen = s.nextInt();
        int timeDel = s.nextInt();
        //System.out.println(size + " " + queue + " " + timeDel + " "+ timeGen);
        parking = new Parking(size, queue);
        Stats st = new Stats();
        Adder adder = new Adder(timeGen);
        Remover remover = new Remover(timeDel);
        adder.start();
        st.start();
        remover.run();
    }
}
