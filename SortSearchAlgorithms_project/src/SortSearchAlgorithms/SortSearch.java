package SortSearchAlgorithms;

import java.util.ArrayList;

public class SortSearch {

    public static int linearSearch(int[] array, int wanted) {
        for (int idx = 0; idx < array.length; idx++) {

            if (array[idx] == wanted) {
                return idx;
            }
        }
        return -1;
    }


    public static int[] insertionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && key < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            
            array[j+1] = key;
        }
        return array;
    }


    public static int[] selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n-1; i++) {
            int smallest, smallest_idx;
            smallest = array[i];
            smallest_idx = i;

            for (int j = i + 1; j < n; j++) {

                if (array[j] < smallest) {
                    smallest = array[j];
                    smallest_idx = j;
                }
            }

            array[smallest_idx] = array[i];
            array[i] = smallest;
        }

        return array;
    }


    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {break;}
        }
        return array;
    }
    
    
    public static int binarySearch(int[] array, int wanted) {
        int n = array.length;
        int low = 0;
        int up = n - 1;

        while (low <= up) {
            int mid = (up - low) / 2 + low;

            if (wanted == array[mid]) {
                return mid;
            }
            if(wanted < array[mid]) {
                up = mid - 1;
            }
            if (wanted > array[mid]) {
                low = mid + 1;
            }
        }

        return -1;
    }


//    public static void mergeSort(int[] array, int start, int end) {
//        int mid = (end - start) / 2 + start;
//
//        mergeSort(array, start, mid);
//        mergeSort(array, mid + 1, end);
//
//        merge(leftArray, rightArray);
//    }
//
//    private static int[] merge(int[] leftArray, int[] rightArray) {
//        int lLen = leftArray.length;
//        int rLen = rightArray.length;
//        int[] temp = new int[lLen + rLen];
//        int k = 0;
//
//        for (int i = 0, j = 0; i < lLen && j < rLen;) {
//
//            if (leftArray[i] < rightArray[j]) {
//                temp[k++] = leftArray[i];
//                i++;
//            } else {
//                temp[k++] = leftArray[j];
//                j++;
//            }
//        }
//        return null;
//    }
}
