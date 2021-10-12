package Opgave6Bil;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());
		System.out.println(myCar.getKm());

		Car myNewCar = new Car("Tesla X", "Black");
		System.out.println(myNewCar.getBrand() + " " + myNewCar.getColor());
		myNewCar.setRegistrationNumber("CU 38 358");
		myNewCar.setKm(30472);
		System.out.println("**************************");
		System.out.println(myNewCar.getBrand() + " " + myNewCar.getColor());
		System.out.println(myNewCar.getRegistrationNumber() + " har kørt " + myNewCar.getKm());
		System.out.println("'*************************");



	}

}
