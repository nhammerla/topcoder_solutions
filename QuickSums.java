// http://community.topcoder.com/stat?c=problem_statement&pm=2829&rd=5072
class QuickSums {
  public static int minSums(String numbers, int sum) {
    return QuickSums.minSums(numbers, sum, 0, new String(""));
  }

  // for recursion
  public static int minSums(String numbers, int sum, int numSum, String seq) {
    if (sum < 0) {
      // we overshot
      return -1;
    }

    if (numbers.length() == 0) {
      // no more sequence left, let's check result
      if (sum == 0) {
        // found one!
        System.out.println(seq); // for debugging
        return numSum;
      } else {
        // this didn't work
        return -1;
      }
    }

    // initialise
    int res1 = -1;
    int res2 = -1;

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
      if (res1 == -1 && res2 == -1) {
        return -1;
      } else if (res1 == -1 && res2 != -1) {
        return res2;
      } else if (res1 != -1 && res2 == -1) {
        return res1;
      } else {
        // return smaller number of sums
        return res1 < res2 ? res1 : res2;
      }
    }
  }

  public static void main(String[] args) {
    String numbers = new String("382834");
    int target = 100;
    System.out.println("Minimum additions: " + QuickSums.minSums(numbers, target));

  }
}