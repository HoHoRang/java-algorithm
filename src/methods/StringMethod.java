package methods;

public class StringMethod {
  public static void main(String[] args) {
    String str = "programming.is.hard";

//    // 문자열 순회
//    int[] cnt = new int[26];
////    for (char c: str.toCharArray()) {
////      System.out.println(c);
////      if (c >= 'a' && c <= 'z')  cnt[c - 'a']++;
////    } // (1)
//    str.chars().filter(e -> e >= 'a' && e <= 'z').forEach(e -> cnt[e - 'a']++); // (2)
//    for (int i = 0; i < cnt.length; i++) {
//      System.out.println((char) (i + 'a') + " : " + cnt[i]);
//    }

    // split
    String[] b = str.split("\\."); // regex라 \\.과 같이 써야 함
    for (String s : b) {
      System.out.println(s);
    }

    // indexOf
    int c = str.indexOf("g");
    System.out.println(c);

    // substring
    String d = str.substring(0, 3);
    System.out.println(d);
  }
}
