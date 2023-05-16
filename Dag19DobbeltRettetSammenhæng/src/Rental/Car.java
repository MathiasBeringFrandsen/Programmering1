package Rental;

import java.util.ArrayList;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private final ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String license, int year) {
        this.license = license;
        this.purchaseYear = year;
    }

    public void setDayPrice(double price) {
        this.pricePerDay = price;
    }

    public double getDayPrice() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public ArrayList<Rental> getRentals(){
        return new ArrayList<>(rentals);
    }

    public void addRental(Rental rental) {
        if (!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental(Rental rental) {
        if (rentals.contains(rental)) {
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    public int longestRent(){
        int longestRent= 0;
        for (Rental rental : rentals) {
            if (rental.getDays() > longestRent) {
                longestRent = rental.getDays();
            }
        }
        return longestRent;
    }

}