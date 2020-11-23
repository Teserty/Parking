package tes.classes;

public class Car {
    public boolean isTruck() {
        return isTruck;
    }

    public void setTruck(boolean truck) {
        isTruck = truck;
    }

    private boolean isTruck;
    private int id;

    public Car(int id, boolean isTruck) {
        this.id = id;
        this.isTruck = isTruck;
    }
    public int getSize(){
        return isTruck? 2 : 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printOut(){
        System.out.println((isTruck? "Грузовой": "Легковой") + " автомобиль с id = "+id +" покинул парковку.");
    }
    public void printIn(){
        System.out.println((isTruck? "Грузовой": "Легковой") + " автомобиль с id = "+id +" встал в очередь на въезд.");
    }
    public void printInParking(){
        System.out.println((isTruck? "Грузовой": "Легковой") + " автомобиль с id = "+id +" припарковался.");
    }
}
