package soegningelevopgaver;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

		System.out.println();

		int[] talArray2 = {7, 56, 34, 3, 7, 14, 13, 4};
		System.out.println(s.containsTenToFifteen(talArray2));

		System.out.println();

		int[] talArray3 = {7, 9, 13, 7, 9, 13};
		int[] talArray4 = {7, 9, 13, 13, 9, 7};
		System.out.println(s.twoOfAKind(talArray3));
		System.out.println(s.twoOfAKind(talArray4));
	}

}
