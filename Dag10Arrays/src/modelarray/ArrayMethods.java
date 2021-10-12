package modelarray;

public class ArrayMethods {
    public void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            } else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    /**
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }

    /**
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public int[] fyldArrayB() {
        int[] result = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public int[] fyldArrayC() {
        int[] result = new int[10];
        for (int i = 0; i < 10; i++)
            result[i] = i;
        return result;
    }

    /**
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public int[] fyldArrayD() {
        int[] result = new int[10];
        for (int i = 0; i < 10; i++)
            result[i] = (i + 1) * 2;
        return result;
    }

    /**
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public int[] fyldArrayE() {
        int[] result = new int[10];
        for (int i = 1; i <= 10; i++)
            result[i - 1] = i * i;
        return result;
    }

    /**
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public int[] fyldArrayF() {
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public int[] fyldArrayG() {
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            result[i] = i;
            if (i >= 5) {
                result[i] = i - 5;
            }
        }
        return result;
    }

    public int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }

    public int sum(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum = sum + t[i];
        }
        return sum;
    }

    public double sumDouble(double[] t) {
        double sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum = sum + t[i];
        }
        return sum;
    }

    public int[] makeSum(int[] a, int[] b) {
        int[] sum;
        if (a.length >= b.length) {
            sum = new int[a.length];
        } else {
            sum = new int[b.length];
        }
        for (int i = 0; i < sum.length; i++) {
            if (i < a.length && i < b.length) {
                sum[i] = a[i] + b[i];
            } else if (i < a.length){
                sum[i] = a[i];
            } else{
                sum[i] = b[i];
            }
        }
        return sum;
    }

    public boolean hasUneven(int[] t) {
        boolean hasUneven = false;
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 1) {
                hasUneven = true;
            }
        }
        return hasUneven;
    }

    public void switchFirstAndLast(int[] t){
        int last = t[t.length - 1];
        t[t.length - 1] = t[0];
        t[0] = last;
    }

    public void changeOneToTheRight(int[] t){
        int last = t[t.length - 1];
        for (int i = t.length - 1; i > 0; i--){
                t[i] = t[i -1];
        }
        t[0] = last;
    }

    public void evenToZero(int[] t){
        for (int i = 0; i < t.length; i++){
            if (t[i] % 2 == 0){
                t[i] = 0;
            }
        }
    }

    public int nextHighest(int[] t){
        int nextHighest = t[0];
        int highest = findMax(t);
        for (int tal : t) {
            if (nextHighest < tal && tal < highest) {
                nextHighest = tal;
                System.out.println("tal er nu: " + tal);
            }
        }
        return nextHighest;
    }

}