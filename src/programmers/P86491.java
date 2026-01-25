package programmers;

// 최소직사각형
public class P86491 {

  public static void main(String[] args) {
    P86491 instance = new P86491();

    int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

    System.out.println(instance.solution(sizes));
  }

  public int solution(int[][] sizes) {
    int answer = 0;

    // 명함들을 [작은 길이, 큰 길이]로 정렬
    for (int i = 0; i < sizes.length; i++) {
      if (sizes[i][0] > sizes[i][1]) {
        int temp = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = temp;
      }
    }

    int shortMax = 0;
    int longMax = 0;

    for (int i = 0; i < sizes.length; i++) {
      if (sizes[i][0] > shortMax) {
        shortMax = sizes[i][0];
      }
      if (sizes[i][1] > longMax) {
        longMax = sizes[i][1];
      }
    }
    answer = shortMax * longMax;

    return answer;
  }
}
