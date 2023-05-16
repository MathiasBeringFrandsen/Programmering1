package sortering.sortering;

public class BubbelSortering {
	private static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public static void bubbleSort(int[] list) {
		for (int i = list.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (list[j] > list[j + 1])
					swap(list, j, j + 1);
			}
		}
	}

	private static void swapStrings(String[] list, int i, int j) {
		String temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public static void bubbleSortString(String[] list){
		for (int i = list.length -1; i >= 0; i--) {
			for (int j = 0; j <= i -1;j++){
				if (list[j].compareTo(list[j+1]) > 0){
					swapStrings(list, j, j+1);
				}
			}
		}
	}

}
