package sortering.sortering;

import sortering.model.Customer;

import java.util.ArrayList;

public class SelectionSort {
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minPos]) {
                    minPos = j;
                }
                
            }
            swap(list, i, minPos);
        }
    }

    private static void swapStrings(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void selectionSortStrings(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) < 0)  {
                    minPos = j;
                }

            }
            swapStrings(list, i, minPos);
        }
    }

    private static void swapCustomer(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,temp);
    }

    public static void selectionSortCustomers(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minPos)) < 0)  {
                    minPos = j;
                }

            }
            swapCustomer(list, i, minPos);
        }
    }

    
}
