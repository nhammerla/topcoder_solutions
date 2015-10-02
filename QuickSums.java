// http://community.topcoder.com/stat?c=problem_statement&pm=2829&rd=5072
class QuickSums {
  public static int minSums(String numbers, int sum) {
    int res = QuickSums.minSums(numbers, sum, 0, new String(""));
    return (res == Integer.MAX_VALUE ? -1 : res-1); // note res-1 as we count operands, not summations.
  }

  // for recursion
  public static int minSums(String numbers, int sum, int numSum, String seq) {
    if (sum < 0) {
      // we overshot
      return Integer.MAX_VALUE;
    }

    if (numbers.length() == 0) {
      // no more sequence left, let's check result
      if (sum == 0) {
        // found one!
        System.out.println(seq); // for debugging
        return numSum;
      } else {
        // this didn't work
        return Integer.MAX_VALUE;
      }
    }

    // initialise
    int res1 = Integer.MAX_VALUE;
    int res2 = Integer.MAX_VALUE;

    if (numbers.substring(0,1).equals("0")) {
      // special case: don't add zeros
      return QuickSums.minSums(numbers.substring(1), sum, numSum, seq+'-');
    } else {
      // first character is not a zero!

      // let's get result if we add the first number
      res1 = QuickSums.minSums(numbers.substring(1), sum - Integer.parseInt(numbers.substring(0,1)), numSum+1, seq+'1');

      // let's get result if we add the next two (if there are two left)
      if (numbers.length() >= 2) {
        res2 = QuickSums.minSums(numbers.substring(2), sum - Integer.parseInt(numbers.substring(0,2)), numSum+1, seq+'2');
      }

      // check and return
      return Math.min(res1, res2);
    }
  }

  public static void main(String[] args) {
    String numbers = new String("9230560001");
    int target = 71;
    System.out.println("Minimum additions: " + QuickSums.minSums(numbers, target));

  }
}