// http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
class ZigZag {
  public static int longestZigZag2(int[] sequence) {
    // catch trivial case
    if (sequence.length <= 1) {
      // length of 0, or 1
      return sequence.length;
    } 
    
    int longest = 0;
    int current = 0;
    int lastChange = 0;
    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i-1] < sequence[i]) {
        if (lastChange == -1) {
          current++;
        } else {
          if (current > longest) {
            longest = current;
          }
          current = 1;
        }
        lastChange = 1;
      } else if (sequence[i-1] > sequence[i]) {
        if (lastChange == 1) {
          current++;
        } else {
          if (current > longest) {
            longest = current;
          }
          current = 1;
        }
        lastChange = -1;
      } else { 
        // equal
        if (current > longest) {
          longest = current;
        }
        current = 0;
        lastChange = 0;
      }
      System.out.println(lastChange);
    }
    return longest;
  } 
  
  public static int longestZigZag(int[] sequence) {
    // catch trivial case
    if (sequence.length <= 1) {
      // length of 0, or 1
      return sequence.length;
    } 
    
    int longest = 0;
    int lastChange = -2;
    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i-1] > sequence[i]) {
        if (lastChange == 1 || lastChange == -2) {
          longest = (longest == 0) ? 2 : longest + 1;
        } 
        lastChange = -1;
      } else if (sequence[i-1] < sequence[i]) {
        if (lastChange == -1 || lastChange == -2) {
          longest = (longest == 0) ? 2 : longest + 1; 
        } 
        lastChange = 1;
      }
    }
    
    return longest;
  }
  
  public static void main(String[] args) {
    int[] fooList = { 
      374, 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
      600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
      67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
      477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
      249, 22, 176, 279, 23, 22, 617, 462, 459, 244 
      };
    System.out.println(ZigZag.longestZigZag(fooList));
  }
}