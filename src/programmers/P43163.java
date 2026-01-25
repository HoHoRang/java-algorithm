package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 단어 변환
public class P43163 {

  public static void main(String[] args) {
    P43163 instance = new  P43163();

    String begin = "hit";
    String target = "cog";
//    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    String[] words = {"hot", "dot", "dog", "lot", "log"};

    System.out.println(instance.solution(begin, target, words));
  }

  public int solution(String begin, String target, String[] words) {
    int answer = 0;

    // 1. 먼저 target이 words에 속하는지 체크
    if (!Arrays.asList(words).contains(target)) {
      return 0;
    }

    // 2. begin부터 시작하여 한 단어씩 변경해서 words에 속하는지 체크 후 다음 탐색(BFS)
    boolean[] visited = new boolean[words.length];

    answer = bfs(begin, target, words, visited, 0);

    return answer;
  }

  public int bfs(String begin, String target, String[] words, boolean[] visited, int cost) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{-1, cost});

    // 순회
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int index = cur[0];
      int currentCost = cur[1];

      String currentWord = index == -1 ? begin : words[index];

      // 끝나는 지점
      if (currentWord.equals(target)) {
        return currentCost;
        }

      // words에서 변경 가능한 단어 하나 선택
      for (int i = 0; i < words.length; i++) {
        if (!visited[i] && isSingleCharDiff(currentWord, words[i])) {
          queue.offer(new int[]{i, currentCost + 1});
        }
      }
    }
    // 변환 안되는 경우
    return 0;
  }

  public boolean isSingleCharDiff(String a, String b) {
    // 한 글자만 다른지 체크
    int strLen = a.length();
    int diffCnt = 0;

    for (int i = 0; i < strLen; i++) {
      if (a.charAt(i) != b.charAt(i)) diffCnt++;
    }

    return diffCnt == 1;
  }
}
