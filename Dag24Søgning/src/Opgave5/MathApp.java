package Opgave5;

public class MathApp {

    public static int squareRootLinear(int number) {
        int i = 1;
        int root = -1;
        while (root == -1) {
            if (i * i > number) {
                root = i - 1;
            } else {
                i++;
            }
        }
        return root;
    }

    public static int squareRootBinary(int number) {
        int left = 0;
        int right = number;
        int root = -1;
        while (root == -1) {
            int middle = (left + right) / 2;
            if (middle * middle <= number && (middle + 1) * (middle + 1) > number) {
                root = middle;
            } else if ((middle + 1) * (middle + 1) > number) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(squareRootLinear(3));
        System.out.println();
        System.out.println(squareRootBinary(10));
    }
}
