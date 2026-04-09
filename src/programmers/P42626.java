package programmers;

import java.util.PriorityQueue;

// 더 맵게
public class P42626 {

  public static void main(String[] args) {
    int[] scoville = {1, 2, 3, 9, 10, 12};

    System.out.println("solution(scoville, 7) = " + solution(scoville, 7));
  }
  
  public static int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int food: scoville) {
      minHeap.add(food);
    }

    // 가장 안 매운 음식이 K 이상일 때까지 반복
    while (minHeap.peek() < K) {
      // 섞을 음식이 없을 때 break
      if (minHeap.size() == 1) {
        answer = -1;
        break;
      }

      int firstFood = minHeap.poll();
      int secondFood = minHeap.poll();

      int mixedFood = firstFood + secondFood * 2;
      answer++;

      minHeap.add(mixedFood);
    }

    return answer;
  }
}
