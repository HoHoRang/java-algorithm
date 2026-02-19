package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 문자열 압축
// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class P60057 {

  public static void main(String[] args) {
    P60057 instance = new P60057();

    String s = "xababcdcdababcdcd";

    System.out.println(instance.solution(s));
  }

  public int solution(String s) {
    int answer = 0;
    List<Integer> strLenList = new ArrayList<>();

    if (s.length() == 1) return 1;

    // 1 ~ 문자열 길이/2만큼 for문으로 압축 케이스 판별
    for (int i = 1; i <= s.length() / 2; i++) {
      String wholeStr = ""; // 만들어지는 문자열
      String curStr = s.substring(0, i); // i만큼 잘라서 만들어진 현재 문자열
      int curCnt = 1; // 현재 문자열의 반복횟수

      // 문자열 돌면서 자름
      for (int j = i; j < s.length(); j += i) {
        // 문자열 비교
        String nextStr = s.substring(j, Math.min(j + i, s.length()));

        // 같으면
        if (curStr.equals(nextStr)) {
          curCnt++;
        }
        // 다르면 지금까지 문자열 붙이고 현재 문자열, 횟수 초기화
        else {
          if (curCnt >= 2) {
            wholeStr = wholeStr.concat(String.valueOf(curCnt));
          }
          wholeStr = wholeStr.concat(curStr);
          curStr = nextStr;
          curCnt = 1;
        }

      }

      // 마지막 처리
      if (curCnt >= 2) wholeStr = wholeStr.concat(String.valueOf(curCnt));
      wholeStr = wholeStr.concat(curStr);

      strLenList.add(wholeStr.length());
//      System.out.println(wholeStr);
    }

    answer = Collections.min(strLenList);

    return answer;
  }
}
