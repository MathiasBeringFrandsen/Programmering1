package Opgave123;

public class Kunde implements Comparable<Kunde> {
	private String lastName;
	private String firstName;
	private int age;
	
	public Kunde(String lastName, String firstName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	
	@Override
    public int compareTo(Kunde kunde) {
		int comp = lastName.compareTo(kunde.getLastName());
		if (comp == 0) {
			comp = firstName.compareTo(kunde.getFirstName());
			if (comp==0) {
				comp = age- kunde.getAge();
			}
		}
		return comp;
	}

	public int getAge() {
		return age;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	@Override
    public String toString(){
		return lastName + " " + firstName + " " + age;
	}
}
