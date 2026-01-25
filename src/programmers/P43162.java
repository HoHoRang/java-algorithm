package programmers;

// 네트워크
public class P43162 {

  public static void main(String[] args) {
    P43162 instance =  new P43162();

    int n = 3;
    int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    System.out.println(instance.solution(n, computers));
  }

  public int solution(int n, int[][] computers) {
    int answer = 0;

    boolean[] visited = new boolean[n];

    // 깊이 탐색하다가 끊기면 하나의 네트워크로 간주(이미 방문한 곳은 별도 네트워크로 치지 않음)
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, computers, visited);
        answer++;
      }
    }

    return answer;
  }

  public void dfs(int computer, int[][] computers, boolean[] visited) {
    visited[computer] = true;
    System.out.println(computer + " visited!");

    for (int i = 0; i < computers.length; i++) {
      int[] connected =  computers[computer];

      // 본인이 아닐때만
      if (i != computer && connected[i] == 1 && !visited[i]) {
        dfs(i, computers, visited);
      }
    }
  }
}
