package SortSearchAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//        // Linear Search test - - - - - - - - - - - - - - - - - - -
//        int n = Integer.parseInt(br.readLine());
//
//        String input = br.readLine();
//        String[] parts = input.split("\\s+");
//
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = Integer.parseInt(parts[i]);
//        }
//
//        int wanted = Integer.parseInt(br.readLine());
//
//        int result;
//        result = SortSearch.linearSearch(array, wanted);
//        System.out.println(result);


//        // Insertion Sort test - - - - - - - - - - - - - - - - - - -
//        int n = Integer.parseInt(br.readLine());
//
//        String input = br.readLine();
//        String[] parts = input.split("\\s+");
//
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = Integer.parseInt(parts[i]);
//        }
//
//        int[] result;
//        result = SortSearch.insertionSort(array);
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(result[i] + " ");
//        }


//        // Selection Sort test - - - - - - - - - - - - - - - - - - -
//        int n = Integer.parseInt(br.readLine());
//
//        String input = br.readLine();
//        String[] parts = input.split("\\s+");
//
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = Integer.parseInt(parts[i]);
//        }
//
//        int[] result;
//        result = SortSearch.selectionSort(array);
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(result[i] + " ");
//        }


//        // Bubble Sort test - - - - - - - - - - - - - - - - - - -
//        int n = Integer.parseInt(br.readLine());
//
//        String input = br.readLine();
//        String[] parts = input.split("\\s+");
//
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = Integer.parseInt(parts[i]);
//        }
//
//        int[] result;
//        result = SortSearch.bubbleSort(array);
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(result[i] + " ");
//        }
//

        // Binary Search test - - - - - - - - - - - - - - - - - - -
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        String[] parts = input.split("\\s+");

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }

        int wanted = Integer.parseInt(br.readLine());

        int result;
        result = SortSearch.binarySearch(array, wanted);
        System.out.println(result);


        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        br.close();
    }
}
