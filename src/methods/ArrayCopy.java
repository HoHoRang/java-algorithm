package methods;

public class ArrayCopy {
  public static void main(String[] args) {
    int[] a = {1, 2, 1, 4, 5};
    int[] b = new int[a.length];
    System.arraycopy(a, 0, b, 0, a.length);
    for (int i: b) {
      System.out.println(i);
    }
  }
}
