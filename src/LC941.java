public class LC941 {
    public boolean validMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length - 2 && arr[left] < arr[left + 1]) left++;
        while (right > 0 && arr[right - 1] > arr[right]) right--;
        return left == right;
    }
}
