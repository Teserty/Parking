package tes.classes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Parking {
    private int size;
    private final List<Car> cars = Collections.synchronizedList(new LinkedList<>());
    ArrayBlockingQueue<Car> arrayDeque;
    private static int acc = 0;
    public void AddToQueue(Car newCar){
        newCar.printIn();
        try {
            arrayDeque.add(newCar);
        } catch (IllegalStateException e) {
            printStatistics();
            System.out.println("Alarm: Queue full");
            System.exit(0);
        }
    }
    public void addCar(Car newCar){
        if (getFreeSpace() != 0){

            if(arrayDeque.peek() == null){
                AddToQueue(newCar);
                if (getFreeSpace() >= newCar.getSize()){
                    arrayDeque.peek().printInParking();
                    cars.add(arrayDeque.poll());
                }
            }else {
                if (getFreeSpace() >= arrayDeque.peek().getSize()){
                    arrayDeque.peek().printInParking();
                    cars.add(arrayDeque.poll());
                }
                AddToQueue(newCar);
            }
        }else {
            AddToQueue(newCar);
        }
    }
    public void addCar(){
        addCar(new Car(acc, acc % 4 == 0));
        acc++;
    }
    public void removeCar(){
        if(cars.size()> 0) {
            cars.get(0).printOut();
            cars.remove(0);
            if (arrayDeque.peek() != null) {
                if (getFreeSpace() >= arrayDeque.peek().getSize()) {
                    addCar(arrayDeque.poll());
                }
            }
        }
    }
    public Parking(int size, int queue){
        this.size = size;
        this.arrayDeque = new ArrayBlockingQueue<>(queue);
    }
    public synchronized int getFreeSpace(){
        int currentSize = 0;
        for (Car car: cars) {
            currentSize += car.getSize();
        }
        return size-currentSize;
    }
    public void printStatistics(){
        int trucks = 0;
        int lcars = 0;
        synchronized (cars) {
            for (Car i : cars) {
                if (i.isTruck())
                    trucks++;
                else
                    lcars++;
            }
        }
        int sum = trucks*2+lcars;
        System.out.println("- Свободных мест: "+(size-sum));
        System.out.println("- Занятно мест: "+sum +"(Из них грузовых авто - "+ trucks+", легковых - " + lcars + ")");
        System.out.println("- Автомобилей, ожидающих в очереди: "+arrayDeque.size());
    }
}
