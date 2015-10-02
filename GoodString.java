// http://community.topcoder.com/stat?c=problem_statement&pm=13751
public class GoodString {
	public static String isGood(String s) {
		// trivial case
		if (s.length() % 2 != 0) {
			// must be even length
			return new String("Bad");
		}
		
		if (s.length() == 0 || (s.length() > 0 && s.substring(0,1).equals("b"))) {
			return new String("Bad");
		}
		
		int as = 0;
		int bs = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i,i+1).equals("a")) { as++; } 
			else if (s.substring(i,i+1).equals("b")) { bs++; }
		}
		
		if (as == bs) {
			return "Good";
		} else {
			return "Bad";
		}
	}
	
	public static void main(String[] args) {
		String s = new String("abaababababbaabbaaaabaababaabbabaaabbbbbbbb");
		System.out.println(GoodString.isGood(s));
		s = new String("aaaaaaaabbbaaabaaabbabababababaabbbbaabbabbbbbbabb");
		System.out.println(GoodString.isGood(s));
		s = new String("ababab");
		System.out.println(GoodString.isGood(s));
	}
	
}