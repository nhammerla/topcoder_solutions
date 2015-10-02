// http://community.topcoder.com/stat?c=problem_statement&pm=13672&rd=16314

public class TaroJiroDividing {
  public static int getNumber(int A, int B) {
    // find common divisors
    return getNumber(A, B, 0);
  }
  
  public static int getNumber(int a, int b, int match) {
    // shortcut if both are the same, no more recursion
    if (a == b) {
      match++;
      do {
        a /= 2;  
        match++;
      } while (a % 2 == 0);
      return match;
    }
    
    // otherwise we continue dividing
    if (a < b && b % 2 == 0) {
      return getNumber(a, b/2, match);
    } else if (a > b && a % 2 == 0) {
      return getNumber(a/2, b, match);
    } 
    
    // when we reached here we return the list-size.
    return match;
  }
  
  public static void main(String[] args) {
    System.out.println(TaroJiroDividing.getNumber(8,4));
    System.out.println(TaroJiroDividing.getNumber(7,4));
    System.out.println(TaroJiroDividing.getNumber(12,12));
    System.out.println(TaroJiroDividing.getNumber(24,96));
  }
}