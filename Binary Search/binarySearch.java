
class binarySearch {

    public static int search(int nums[], int low, int high,int target) {

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] < target) {
                low = mid + 1;
            }else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int low = 0;
        int high = nums.length-1;
        int target = 8;
        System.out.println("Index: " + search(nums, low, high, target));
    }
}
