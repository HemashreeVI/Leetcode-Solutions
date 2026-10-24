"""Compiles every Solution.java and runs it against LeetCode's examples plus edge cases.

Usage:  python3 tests/run_tests.py      (needs a JDK on PATH)

Each solution is compiled on its own (they're all named `Solution`) together with
stub ListNode/TreeNode classes and a small Main that runs the checks in T below.
When you add a new problem, add a line to T with its 4-digit number.
"""
import os, subprocess, shutil, sys, glob
REPO = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
HERE = os.path.join(REPO, "build", "tests")
STUBS = """
class ListNode { int val; ListNode next; ListNode() {} ListNode(int v) { val = v; } ListNode(int v, ListNode n) { val = v; next = n; } }
class TreeNode { int val; TreeNode left, right; TreeNode() {} TreeNode(int v) { val = v; } TreeNode(int v, TreeNode l, TreeNode r) { val = v; left = l; right = r; } }
class H {
  static void eq(Object a, Object b) { if (!java.util.Objects.equals(String.valueOf(a), String.valueOf(b))) throw new AssertionError("got " + a + " expected " + b); }
  static String a(int[] x) { return java.util.Arrays.toString(x); }
  static String a2(int[][] x) { return java.util.Arrays.deepToString(x); }
  static ListNode list(int... v) { ListNode d = new ListNode(); ListNode t = d; for (int x : v) { t.next = new ListNode(x); t = t.next; } return d.next; }
  static String s(ListNode n) { StringBuilder b = new StringBuilder(); while (n != null) { b.append(n.val).append(n.next != null ? "," : ""); n = n.next; } return b.toString(); }
  // level-order build, null = Integer null
  static TreeNode tree(Integer... v) { if (v.length == 0 || v[0] == null) return null; TreeNode r = new TreeNode(v[0]); java.util.Queue<TreeNode> q = new java.util.LinkedList<>(); q.add(r); int i = 1; while (i < v.length) { TreeNode n = q.poll(); if (i < v.length && v[i] != null) { n.left = new TreeNode(v[i]); q.add(n.left); } i++; if (i < v.length && v[i] != null) { n.right = new TreeNode(v[i]); q.add(n.right); } i++; } return r; }
}
"""
T = {
"0001": 'H.eq(H.a(s.twoSum(new int[]{2,7,11,15},9)),"[0, 1]"); H.eq(H.a(s.twoSum(new int[]{3,2,4},6)),"[1, 2]"); H.eq(H.a(s.twoSum(new int[]{3,3},6)),"[0, 1]");',
"0066": 'H.eq(H.a(s.plusOne(new int[]{1,2,9})),"[1, 3, 0]"); H.eq(H.a(s.plusOne(new int[]{9,9})),"[1, 0, 0]"); H.eq(H.a(s.plusOne(new int[]{0})),"[1]");',
"0121": 'H.eq(s.maxProfit(new int[]{7,1,5,3,6,4}),5); H.eq(s.maxProfit(new int[]{7,6,4,3,1}),0);',
"0169": 'H.eq(s.majorityElement(new int[]{2,2,1,1,1,2,2}),2); H.eq(s.majorityElement(new int[]{3,2,3}),3);',
"0215": 'H.eq(s.findKthLargest(new int[]{3,2,1,5,6,4},2),5); H.eq(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4),4);',
"1295": 'H.eq(s.findNumbers(new int[]{12,345,2,6,7896}),2); H.eq(s.findNumbers(new int[]{555,901,482,1771}),1);',
"1480": 'H.eq(H.a(s.runningSum(new int[]{1,2,3,4})),"[1, 3, 6, 10]");',
"1672": 'H.eq(s.maximumWealth(new int[][]{{1,5},{7,3},{3,5}}),10); H.eq(s.maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}}),17);',
"1920": 'H.eq(H.a(s.buildArray(new int[]{0,2,1,5,3,4})),"[0, 1, 2, 4, 5, 3]");',
"1929": 'H.eq(H.a(s.getConcatenation(new int[]{1,2,1})),"[1, 2, 1, 1, 2, 1]");',
"3483": 'H.eq(s.totalNumbers(new int[]{1,2,3,4}),12); H.eq(s.totalNumbers(new int[]{0,2,2}),2); H.eq(s.totalNumbers(new int[]{6,6,6}),1); H.eq(s.totalNumbers(new int[]{1,3,5}),0);',
"3550": 'H.eq(s.smallestIndex(new int[]{1,3,2}),2); H.eq(s.smallestIndex(new int[]{1,10,11}),1); H.eq(s.smallestIndex(new int[]{1,2,3}),-1);',
"3551": 'H.eq(s.minSwaps(new int[]{37,100}),1); H.eq(s.minSwaps(new int[]{22,14,33,7}),0); H.eq(s.minSwaps(new int[]{18,43,34,16}),2);',
"3668": 'H.eq(H.a(s.recoverOrder(new int[]{3,1,2,5,4},new int[]{1,3,4})),"[3, 1, 4]"); H.eq(H.a(s.recoverOrder(new int[]{1,4,5,3,2},new int[]{2,5})),"[5, 2]");',
"0026": 'int[] a={0,0,1,1,1,2,2,3,3,4}; int k=s.removeDuplicates(a); H.eq(k,5); H.eq(H.a(java.util.Arrays.copyOf(a,k)),"[0, 1, 2, 3, 4]");',
"0027": 'int[] a={0,1,2,2,3,0,4,2}; int k=s.removeElement(a,2); H.eq(k,5); int[] b=java.util.Arrays.copyOf(a,k); java.util.Arrays.sort(b); H.eq(H.a(b),"[0, 0, 1, 3, 4]");',
"0042": 'H.eq(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}),6); H.eq(s.trap(new int[]{4,2,0,3,2,5}),9);',
"0088": 'int[] a={1,2,3,0,0,0}; s.merge(a,3,new int[]{2,5,6},3); H.eq(H.a(a),"[1, 2, 2, 3, 5, 6]"); int[] b={0}; s.merge(b,0,new int[]{1},1); H.eq(H.a(b),"[1]");',
"0977": 'H.eq(H.a(s.sortedSquares(new int[]{-4,-1,0,3,10})),"[0, 1, 9, 16, 100]"); H.eq(H.a(s.sortedSquares(new int[]{-7,-3,2,3,11})),"[4, 9, 9, 49, 121]");',
"0013": 'H.eq(s.romanToInt("MCMXCIV"),1994); H.eq(s.romanToInt("LVIII"),58); H.eq(s.romanToInt("III"),3);',
"0014": 'H.eq(s.longestCommonPrefix(new String[]{"flower","flow","flight"}),"fl"); H.eq(s.longestCommonPrefix(new String[]{"dog","racecar","car"}),"");',
"0028": 'H.eq(s.strStr("sadbutsad","sad"),0); H.eq(s.strStr("leetcode","leeto"),-1); H.eq(s.strStr("hello","ll"),2);',
"0058": 'H.eq(s.lengthOfLastWord("   fly me   to   the moon  "),4); H.eq(s.lengthOfLastWord("Hello World"),5);',
"3498": 'H.eq(s.reverseDegree("abc"),148); H.eq(s.reverseDegree("zaza"),160);',
"3675": 'H.eq(s.minOperations("yz"),2); H.eq(s.minOperations("a"),0); H.eq(s.minOperations("b"),25);',
"0009": 'H.eq(s.isPalindrome(121),true); H.eq(s.isPalindrome(-121),false); H.eq(s.isPalindrome(10),false); H.eq(s.isPalindrome(12321),true); H.eq(s.isPalindrome(0),true);',
"0204": 'H.eq(s.countPrimes(10),4); H.eq(s.countPrimes(0),0); H.eq(s.countPrimes(1),0); H.eq(s.countPrimes(3),1); H.eq(s.countPrimes(5000000),348513);',
"1317": 'int[] r=s.getNoZeroIntegers(11); H.eq(r[0]+r[1],11); H.eq(H.a(s.getNoZeroIntegers(2)),"[1, 1]"); int[] q=s.getNoZeroIntegers(10000); H.eq(q[0]+q[1],10000); H.eq(String.valueOf(q[0]).contains("0")||String.valueOf(q[1]).contains("0"),false);',
"0021": 'H.eq(H.s(s.mergeTwoLists(H.list(1,2,4),H.list(1,3,4))),"1,1,2,3,4,4"); H.eq(H.s(s.mergeTwoLists(null,null)),"");',
"0025": 'H.eq(H.s(s.reverseKGroup(H.list(1,2,3,4,5),2)),"2,1,4,3,5"); H.eq(H.s(s.reverseKGroup(H.list(1,2,3,4,5),3)),"3,2,1,4,5"); H.eq(H.s(s.reverseKGroup(H.list(1,2),2)),"2,1");',
"0143": 'ListNode a=H.list(1,2,3,4,5); s.reorderList(a); H.eq(H.s(a),"1,5,2,4,3"); ListNode b=H.list(1,2,3,4); s.reorderList(b); H.eq(H.s(b),"1,4,2,3");',
"0020": 'H.eq(s.isValid("({[]})"),true); H.eq(s.isValid("(]"),false); H.eq(s.isValid("("),false); H.eq(s.isValid("]"),false);',
"0150": 'H.eq(s.evalRPN(new String[]{"4","13","5","/","+"}),6); H.eq(s.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}),22);',
"0224": 'H.eq(s.calculate("1 - (2 + 3)"),-4); H.eq(s.calculate("(1+(4+5+2)-3)+(6+8)"),23); H.eq(s.calculate("-(2+3)"),-5); H.eq(s.calculate(" 2-1 + 2 "),3);',
"1614": 'H.eq(s.maxDepth("(1+(2*3)+((8)/4))+1"),3); H.eq(s.maxDepth("()(())((()()))"),3);',
"0004": 'H.eq(s.findMedianSortedArrays(new int[]{1,3},new int[]{2}),2.0); H.eq(s.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}),2.5); H.eq(s.findMedianSortedArrays(new int[]{},new int[]{1}),1.0);',
"0035": 'H.eq(s.searchInsert(new int[]{1,3,5,6},5),2); H.eq(s.searchInsert(new int[]{1,3,5,6},2),1); H.eq(s.searchInsert(new int[]{1,3,5,6},7),4);',
"0017": 'H.eq(s.letterCombinations("23"),"[ad, ae, af, bd, be, bf, cd, ce, cf]"); H.eq(s.letterCombinations(""),"[]");',
"0022": 'H.eq(s.generateParenthesis(3),"[((())), (()()), (())(), ()(()), ()()()]"); H.eq(s.generateParenthesis(1),"[()]");',
"0039": 'H.eq(s.combinationSum(new int[]{2,3,6,7},7),"[[2, 2, 3], [7]]"); H.eq(s.combinationSum(new int[]{2},1),"[]");',
"0046": 'H.eq(s.permute(new int[]{1,2,3}),"[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]");',
"0054": 'H.eq(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}),"[1, 2, 3, 6, 9, 8, 7, 4, 5]"); H.eq(s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}),"[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]"); H.eq(s.spiralOrder(new int[][]{{1},{2},{3}}),"[1, 2, 3]");',
"0073": 'int[][] m={{1,1,1},{1,0,1},{1,1,1}}; s.setZeroes(m); H.eq(H.a2(m),"[[1, 0, 1], [0, 0, 0], [1, 0, 1]]"); int[][] n={{0,1,2,0},{3,4,5,2},{1,3,1,5}}; s.setZeroes(n); H.eq(H.a2(n),"[[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]");',
"2906": 'H.eq(H.a2(s.constructProductMatrix(new int[][]{{1,2},{3,4}})),"[[24, 12], [8, 6]]"); H.eq(H.a2(s.constructProductMatrix(new int[][]{{12345},{2},{1}})),"[[2], [0], [0]]");',
"0103": 'H.eq(s.zigzagLevelOrder(H.tree(3,9,20,null,null,15,7)),"[[3], [20, 9], [15, 7]]"); H.eq(s.zigzagLevelOrder(null),"[]");',
"0114": 'TreeNode r=H.tree(1,2,5,3,4,null,6); s.flatten(r); StringBuilder b=new StringBuilder(); for(TreeNode t=r;t!=null;t=t.right){ if(t.left!=null) throw new AssertionError("left"); b.append(t.val);} H.eq(b,"123456");',
"0129": 'H.eq(s.sumNumbers(H.tree(1,2,3)),25); H.eq(s.sumNumbers(H.tree(4,9,0,5,1)),1026);',
"0199": 'H.eq(s.rightSideView(H.tree(1,2,3,null,5,null,4)),"[1, 3, 4]"); H.eq(s.rightSideView(H.tree(1,2,3,4,null,null,null,5)),"[1, 3, 4, 5]");',
"1569": 'H.eq(s.numOfWays(new int[]{2,1,3}),1); H.eq(s.numOfWays(new int[]{3,4,5,1,2}),5); H.eq(s.numOfWays(new int[]{1,2,3}),0); int[] big=new int[1000]; for(int i=0;i<1000;i++) big[i]=i+1; H.eq(s.numOfWays(big),0);',
"0032": 'H.eq(s.longestValidParentheses("(()"),2); H.eq(s.longestValidParentheses(")()())"),4); H.eq(s.longestValidParentheses(""),0); H.eq(s.longestValidParentheses("()(())"),6);',
"0044": 'H.eq(s.isMatch("aa","a"),false); H.eq(s.isMatch("aa","*"),true); H.eq(s.isMatch("cb","?a"),false); H.eq(s.isMatch("adceb","*a*b"),true); H.eq(s.isMatch("acdcb","a*c?b"),false);',
"0070": 'H.eq(s.climbStairs(2),2); H.eq(s.climbStairs(3),3); H.eq(s.climbStairs(5),8); H.eq(s.climbStairs(1),1);',
"0118": 'H.eq(s.generate(5),"[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]");',
"0198": 'H.eq(s.rob(new int[]{1,2,3,1}),4); H.eq(s.rob(new int[]{2,7,9,3,1}),12);',
"0322": 'H.eq(s.coinChange(new int[]{1,2,5},11),3); H.eq(s.coinChange(new int[]{2},3),-1); H.eq(s.coinChange(new int[]{1},0),0); H.eq(s.coinChange(new int[]{1,3,4},6),2);',
"0509": 'H.eq(s.fib(2),1); H.eq(s.fib(4),3); H.eq(s.fib(0),0); H.eq(s.fib(30),832040);',
}
fails = 0; seen = set()
for path in sorted(glob.glob(REPO + "/**/Solution.java", recursive=True)):
    num = os.path.basename(os.path.dirname(path))[:4]
    seen.add(num)
    if num not in T: print("NO TEST", path); fails += 1; continue
    d = os.path.join(HERE, "build", num); shutil.rmtree(d, ignore_errors=True); os.makedirs(d)
    shutil.copy(path, d)
    open(os.path.join(d, "Stubs.java"), "w").write(STUBS)
    open(os.path.join(d, "Main.java"), "w").write("public class Main { public static void main(String[] x) { Solution s = new Solution(); " + T[num] + " System.out.println(\"ok\"); } }")
    r = subprocess.run(["javac", "-Xlint:none", "-d", d, path, os.path.join(d, "Stubs.java"), os.path.join(d, "Main.java")], capture_output=True, text=True)
    if r.returncode: print("COMPILE FAIL", num, r.stderr); fails += 1; continue
    r = subprocess.run(["java", "-cp", d, "Main"], capture_output=True, text=True)
    out = r.stdout.strip()
    if out != "ok": print("TEST FAIL", num, out, r.stderr[-800:]); fails += 1
    else: print("PASS", num)
print("tests without a solution:", set(T) - seen or "none")
print("FAILURES:", fails)
sys.exit(1 if fails else 0)
