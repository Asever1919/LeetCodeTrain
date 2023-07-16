package WeekExam;

public class LC6462 {
    public int minimizedStringLength(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                count++;
            }
        }
        return count;
    }
}
