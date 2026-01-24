package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 전화번호 목록
public class P42577 {

  public static void main(String[] args) {
    P42577 instance = new P42577();

    String[] phone_book = {"12","123","1235","567","88"};

    System.out.println(instance.solution(phone_book));
  }

  public boolean solution(String[] phone_book) {
    boolean answer = true;

    Set<String> set = new HashSet<>(Arrays.asList(phone_book));

    for (String phone: phone_book) {
      for (int i = 0; i < phone.length(); i++) {
        if (set.contains(phone.substring(0, i))) return false;
      }
    }

//    for (int i = 0; i < phone_book.length; i++) {
//      for (int j = i + 1; j < phone_book.length; j++) {
//
//        if (phone_book[i].startsWith(phone_book[j]) || phone_book[j].startsWith(phone_book[i])) {
//          return false;
//        }
//      }
//    }

    return answer;
  }
}
