package methods;

public class DP {
  // 중복 계산을 방지하기 위해 결과를 저장하는 배열
  private static int[] memo;
  // 피보나치 수열
  private static int fibo(int n) {
    if (n <= 1) return n;
    // 만약 메모리에 없으면 저장
    if (memo[n] == 0) {
      memo[n] = fibo(n - 1) + fibo(n - 2);
    }
    return memo[n];
  }

  public static void main(String[] args) {
    int num = 5;
    memo = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      System.out.println("fibo(" + i + ") = " + fibo(i));
    }
  }
}
