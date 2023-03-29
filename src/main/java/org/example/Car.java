package org.example;

public class Car {
    private String manufacture,model;

    private int year,horsePower,torque;

    private double engineSize,acceleration,price;

    //Constructor
    public Car(
            String manufacture, String model, int year, double engineSize,
            int horsePower, int torque, double acceleration,double price)
    {

        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
        this.engineSize = engineSize;
        this.torque = torque;
        this.acceleration = acceleration;
        this.price = price;
    }


    //Getter method for manufacture
    public String getmanufacture() {
        return manufacture;
    }
    //Setter method for manufacture
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }


    //Getter method for model
    public String getModel() {
        return model;
    }
    //Setter method for model
    public void setModel(String model) {
        this.model = model;
    }


    //Getter method for year
    public int getYear() {
        return year;
    }
    //Setter method for year
    public void setYear(int year) {
        this.year = year;
    }


    //Getter method for engineSize
    public double getEngineSize() {
        return engineSize;
    }
    //Setter method for engineSize
    public void setEngineSize(double engineSize ) {
        this.engineSize = engineSize;
    }


    //Getter method for horsePower
    public int getHorsePower() {
        return horsePower;
    }
    //Setter method for horsePower
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    //Getter method for torque
    public int getTorque() {
        return torque;
    }
    //Setter method for torque
    public void setTorque(int torque) {
        this.torque = torque;
    }

    //Getter method for acceleration
    public double getAcceleration() {
        return acceleration;
    }
    //Setter method for acceleration
    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    //Getter method for price
    public double getPrice() {
        return price;
    }
    //Setter method for price
    public void setPrice(double price) {
        this.price = price;
    }
}
