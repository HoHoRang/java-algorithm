package programmers;

public class P72410 {

  public static void main(String[] args) {
    P72410 instance = new P72410();

//    String new_id = "...!@BaT#*..y.abcdefghijklm";
    String new_id = "abcdefghijklmn.p";

    System.out.println(instance.solution(new_id));
  }

  public String solution(String new_id) {
    String answer = "";

    // 1단계: 모든 대문자 소문자로 치환
    answer = new_id.toLowerCase();

    // 2단계: 알파벳 소문자, 숫자, 뺴기, 밑줄, 마침표를 제외한 모든 문자 제거
    answer = answer.replaceAll("[^a-z0-9-_.]", "");

    // 3단계: 마침표가 2번 이상 연속된 부분을 하나로
    answer = answer.replaceAll("[.]{2,}", ".");

    // 4단계: 마침표가 처음이나 끝에 위치한다면 제거
    answer = answer.replaceAll("^[.]|[.]$", "");

    // 5단계: 빈 문자열이라면 a를 대입
    if (answer.equals("")) {
      answer = "a";
    }

    // 6단계: 16자 이상이면 첫 15개 문자를 제외한 나머지 문자들을 모두 제거. 제거후 마침표 끝에 있으면 제거
    if (answer.length() >= 16) {
      answer = answer.substring(0, 15);
    }

    answer = answer.replaceAll("[.]$", "");

    // 7단계: 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
    while (answer.length() <= 2) {
      answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));
    }

    return answer;
  }
}
