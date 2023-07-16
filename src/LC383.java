public class LC383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] nums = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            nums[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            nums[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) return false;
        }
        return true;
    }
}
