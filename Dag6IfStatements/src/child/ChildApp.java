package child;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(3, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old

		System.out.println("Et barn på " + c1.getAge());
		System.out.println("Barnet skal i: " + c1.institution());
		System.out.println("Barnet er en " + c1.gender());
		System.out.println("Barnet går på " + c1.team());
		System.out.println("Et barn på " + c2.getAge());
		System.out.println("Barnet er en " + c2.gender());
		System.out.println("Barnet går på " + c2.team());

	}

}
