import java.util.Arrays;

public class SearchAlgo {
  public static void main(String args[]) {
    int[] testArr1 = { 3, 1, 2 };
    int[] testArr2 = { 3, 1, 2, 9, 10, 11, 2, 5, 9 };
    System.out.println(Arrays.toString(bogoSort(testArr2.clone())));
    System.out.println(Arrays.toString(selectionSearch(testArr2.clone())));
  }

  // TIME COMPLEXITY: O(n^2)
  // SPACE COMPLEXITY: O(n)
  public static int[] selectionSearch(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int lowestIndex = i;
      for (int k = i; k < arr.length; k++) {
        if (arr[lowestIndex] > arr[k])
          lowestIndex = k;
      }
      int temp = arr[i];
      arr[i] = arr[lowestIndex];
      arr[lowestIndex] = temp;
    }
    return arr;

  }

  // TIME COMPLEXITY: O((n+1)!) BUT POTENTIAL TO HAVE O(1)
  // SPACE COMPLEXITY: O(n)
  public static int[] bogoSort(int[] arr) {
    while (!isSorted(arr)) {
      // Shuffles Array
      for (int i = 0; i < arr.length; i++) {
        int index1 = (int) (Math.random() * arr.length);
        int index2 = (int) (Math.random() * arr.length);
        int a = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = a;
      }
    }
    return arr;
  }

  public static boolean isSorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1])
        return false;
    }
    return true;
  }
}
