package Opgave1;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 20);
		e1.printEmployee();
		e1.birthday();
		e1.setFirstName("Viggo");
		e1.printEmployee();

	}

}
