package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println();
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

    public int game(int[] guess, int[] answer) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i])
                result++;
        }

        return result;
    }

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            product *= num;
            n /= 10;
        }
        return product - sum;
    }


}
