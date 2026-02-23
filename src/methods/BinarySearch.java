package methods;

import java.util.Arrays;

public class BinarySearch {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int target = 3;

    int index = Arrays.binarySearch(a, target);
    if (index >= 0) {
      System.out.println("Found at: " + index);
    } else {
      System.out.println("Not found");
    }
  }
}
