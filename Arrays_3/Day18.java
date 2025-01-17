// TLE 
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;

        int p = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (2 * nums[j] < nums[i]) {
                    p++;
                }
            }
        }
        return p;
    }
}

// OPTIMAL

class Solution {

    public void merge(int arr[], int low, int mid, int high) {
        List<Integer> res = new ArrayList<>();
        int left = low; // for left half
        int right = mid + 1; // for right half

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                res.add(arr[left]);
                left++;
            } else {
                res.add(arr[right]);
                right++;
            }
        }

        // remaining elements in left half
        while (left <= mid) {
            res.add(arr[left]);
            left++;
        }

        // remaining elements in left half
        while (right <= high) {
            res.add(arr[right]);
            right++;
        }

        // changing the arr according to list

        for (int i = low; i <= high; i++) {
            arr[i] = res.get(i - low);
        }
    }

    public int countPairs(int arr[], int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {

            while (right <= high && arr[i] > (long) 2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1)); // as right starts from mid+1
        }
        return count;
    }

    public int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high)
            return count;

        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    public int reversePairs(int[] nums) {

        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }
}
