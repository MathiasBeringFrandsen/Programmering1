package Opgave4;

public class Person {
    private String name;
    private String address;
    private double monthlySalary;
    private int hiredByCompanies;

    public Person(String inputName, String inputAddress, double inputMonthlySalary){
        name = inputName;
        address = inputAddress;
        monthlySalary = inputMonthlySalary;
        hiredByCompanies = 3;
    }

    public String getName(){

        return name;
    }

    public void setName(String newName){

        name = newName;
    }

    public void setAddress(String newAddress){

        address = newAddress;
    }

    public String getAddress(){

        return address;
    }

    public void setMonthlySalary(double newMonthlySalary){

        monthlySalary = newMonthlySalary;
    }

    public double getYearlySalary(){
        double yearlySalary = (monthlySalary * 12) * 1.025;
        return yearlySalary;
    }

    public void hiredByNewCompany(){

        hiredByCompanies = hiredByCompanies + 1;
    }

    public void printPerson(){
        System.out.println("*******************");
        System.out.println("Navn: " + name);
        System.out.println("Adresse: " + address);
        System.out.println("Månedsløn: " + monthlySalary);
        System.out.println("Årsløn: " + getYearlySalary());
        System.out.println("Ansættelser ved firmaer: " + hiredByCompanies);
    }

}
