//http://community.topcoder.com/stat?c=problem_statement&pm=13912&rd=16520
import java.util.Stack;
import java.util.Arrays;

public class YetAnotherCardGame {
	static int maxCards(int[] P, int[] S) {
		
		Arrays.sort(P);
		Arrays.sort(S);
		
		Stack<Integer> p = new Stack<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i=P.length-1; i >= 0; i--) {
			p.push((Integer) P[i]);
			s.push((Integer) S[i]);
		}
		
		// p makes first move
		int first = p.pop();
		return go(first, s, p, 1);
	}
	
	static int go(int card, Stack nextPlayer, Stack lastPlayer, int stackSize) {
		int elem;
		
		if (nextPlayer.size() == 0) {
			return stackSize;
		}
		
		elem = (int) nextPlayer.pop();
		if (elem > card) {
			return go(elem, lastPlayer, nextPlayer, stackSize+1);
		} else {
			// eat it (no increment)
			return go(card, lastPlayer, nextPlayer, stackSize);
		}
	}
	
	public static void main(String[] args) {
		int[] p = {19, 99, 86, 30, 98, 68, 73, 92, 37, 69, 93, 28, 58, 36, 86, 32, 46, 34, 71, 29};
		int[] s = {28, 29, 22, 75, 78, 75, 39, 41, 5, 14, 100, 28, 51, 42, 9, 25, 12, 59, 98, 83};
		
		System.out.println(YetAnotherCardGame.maxCards(p,s));
	}
}