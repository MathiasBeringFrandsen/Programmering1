package Opgave1;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String firstName;
	private String lastName;
	private boolean trainee;
	private int employeeAge;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputNameOne, String inputNameTwo, int inputAge) {
		firstName = inputNameOne;
		lastName = inputNameTwo;
		trainee = true;
		employeeAge = inputAge;
	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setFirstName(String inputName) {

		firstName = inputName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getFirstName() {

		return firstName;
	}

	public  String getLastName(){
		return lastName;
	}

	public void setLastName(String inputName){
		lastName = inputName;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {

		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {

		return trainee;
	}

	public int getAge(){

		return employeeAge;
	}

	public void setAge(int Age){

		employeeAge = Age;
	}

	public void birthday(){
		employeeAge = employeeAge + 1;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Fornavn: " + firstName);
		System.out.println("Efternavn: "+ lastName);
		System.out.println("Trainee " + trainee);
		System.out.println("Employee is " + employeeAge + " years old.");
		System.out.println();
	}
}
