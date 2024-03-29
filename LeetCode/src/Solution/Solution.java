package Solution;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i : s.sortArray(new int[]{5, 7, 9, 6, 1, 5, 4, 8, 2})) {
            System.out.print(i + " ");
        }
    }

    

    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = 0;


        return result;
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.')
                sb.append("[.]");
            else
                sb.append(c);
        }
        return sb.toString();
    }


    public int numTeams(int[] rating) {
        int n = rating.length;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int[] left = count(rating, 0, i, rating[i]);
            int[] right = count(rating, i, n, rating[i]);
            result += left[0] * right[1] + left[1] * right[0];
        }
        return result;
    }

    private int[] count(int[] rating, int from, int to, int key) {
        int[] results = new int[2];
        for (int i = from; i < to; ++i) {
            if (rating[i] < key)
                ++results[0];
            else if (rating[i] > key)
                ++results[1];
        }
        return results;
    }


    public int lastRemaining(int n, int m) {
        return n == 1 ? 0 : (lastRemaining(n - 1, m) + m) % n;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    public int minimumLengthEncoding(String[] words) {
        int result = 0;
        Set<String> good = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); ++i)
                good.remove(word.substring(i));
        }

        for (String word : good)
            result += word.length() + 1;
        return result;
    }

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            String numsString = String.valueOf(num);
            if (numsString.length() % 2 == 0)
                result++;
        }
        return result;
    }
}