import java.util.Arrays;

public class SearchAlgo {
  public static void main(String args[]) {
    int[] testArr1 = { 3, 1, 2 };
    int[] testArr2 = { 3, 1, 2, 9, 10, 11, 2, 5, 9 };
    int[] testArr3 = { 3, 1, 2, 9, 10, 11, 2, 5, 9 };
    int[] testArr4 = { 3, 1, 2, 9, 10, 11, 2, 5, 9 };
    inserationSort(testArr1);
    mergeSort(testArr2);
    selectionSearch(testArr3);
    bogoSort(testArr4);
    System.out.println(Arrays.toString(testArr1));
    System.out.println(Arrays.toString(testArr2));
    System.out.println(Arrays.toString(testArr3));
    System.out.println(Arrays.toString(testArr4));
  }

  // Time COMPLEXITY: O(n^2) Could be better if use binary search of O(n*logn)
  // SPACE COMPLEXITY: O(n)
  public static void inserationSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int k = i; k > 0; k--) {
        if (arr[k] > arr[k - 1])
          break;
        int temp = arr[k];
        arr[k] = arr[k - 1];
        arr[k - 1] = temp;
      }
    }
  }

  // TIME COMPLEXITY O(n^2)
  // SPACE COMPLEXITY: O(n)
  public static void mergeSort(int[] arr) {
    mergeSortHelper(arr, 0, arr.length - 1, new int[arr.length]);
  }

  private static void mergeSortHelper(int[] arr, int leftStart, int rightEnd, int[] tempArr) {
    if (leftStart >= rightEnd)
      return;

    int middle = (leftStart + rightEnd) / 2;
    mergeSortHelper(arr, leftStart, middle, tempArr);
    mergeSortHelper(arr, middle + 1, rightEnd, tempArr);
    mergeHalfArr(arr, leftStart, rightEnd, tempArr);
  }

  private static void mergeHalfArr(int[] arr, int leftStart, int rightEnd, int[] tempArr) {
    int leftEnd = (leftStart + rightEnd) / 2;
    int rightStart = leftEnd + 1;
    int size = rightEnd - leftStart + 1;

    int left = leftStart;
    int right = rightStart;
    int index = leftStart;

    while (left <= leftEnd && right <= rightEnd) {
      if (arr[left] <= arr[right]) {
        tempArr[index] = arr[left];
        left++;
      } else {
        tempArr[index] = arr[right];
        right++;
      }
      index++;
    }
    System.arraycopy(arr, left, tempArr, index, leftEnd - left + 1);
    System.arraycopy(arr, right, tempArr, index, rightEnd - right + 1);
    System.arraycopy(tempArr, leftStart, arr, leftStart, size);
  }

  // TIME COMPLEXITY: O(n^2)
  // SPACE COMPLEXITY: O(n)
  // Accidently did this one at first
  public static void selectionSearch(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int lowestIndex = i;
      // Tries to find the lowest number from the unsorted array and then it and the
      // current i value swap
      for (int k = i + 1; k < arr.length; k++) {
        if (arr[lowestIndex] > arr[k])
          lowestIndex = k;
      }
      int temp = arr[i];
      arr[i] = arr[lowestIndex];
      arr[lowestIndex] = temp;
    }
  }

  // TIME COMPLEXITY: O((n+1)!) BUT POTENTIAL TO HAVE O(1)
  // SPACE COMPLEXITY: O(n)
  public static void bogoSort(int[] arr) {
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
  }

  public static boolean isSorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1])
        return false;
    }
    return true;
  }
}
