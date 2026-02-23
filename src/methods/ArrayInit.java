package methods;

import java.util.Arrays;

public class ArrayInit {
  public static void main(String[] args) {
    // new int는 0으로 초기화됨
    // boolean은 false
    // String null
    // Integer는 null
    int[] a = new int[5];
    boolean[] b = new boolean[5];
    String[] c = new String[5];
    Integer[] d = new Integer[5];

    for (int i = 0; i < 5; i++) {
      System.out.println(a[i]);
      System.out.println(b[i]);
      System.out.println(c[i]);
      System.out.println(d[i]);
    }

    Arrays.fill(a, 30);

    for (int i = 0; i < 5; i++) {
      System.out.println(a[i]);
      System.out.println(b[i]);
      System.out.println(c[i]);
      System.out.println(d[i]);
    }

    int[][] e = new int[5][5];
    for (int i = 0; i < 5; i++) {
      Arrays.fill(e[i], 30);
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println(e[i][j]);
      }
    }

  }
}
