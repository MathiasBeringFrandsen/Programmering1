package Opgave3;

import java.time.LocalDate;

public class ageDiscount implements Discount{
    private int age;

    public ageDiscount(Customer customer){
        this.age = LocalDate.now().getYear() - customer.getBirthday().getYear();
    }

    @Override
    public double getDiscount(double price) {
        return price * (age / 100.0);
    }
}
