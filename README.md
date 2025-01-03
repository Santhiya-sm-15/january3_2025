# january3_2025
The problems solved today

Here's a breakdown of the problems you've solved today:

1. Valid Splits in an Array (LeetCode Daily Challenge)
- Problem: Determine the number of valid splits in a 0-indexed integer array `nums`, where a split is valid if:
  1. The sum of the first `i + 1` elements is greater than or equal to the sum of the remaining elements.
  2. There's at least one element to the right of index `i`.
- Approach:
  - Compute the total sum of the array.
  - Traverse the array, maintaining a running sum (`s`) of the first `i+1` elements.
  - At each step, check if `s >= totalSum - s`.
  - Count valid splits as you iterate.
- Code:
  class Solution {
      public int waysToSplitArray(int[] nums) {
          long sum = 0;
          for (int x : nums) sum += x;
          int cnt = 0;
          long s = 0;
          for (int i = 0; i < nums.length - 1; i++) {
              s += nums[i];
              if (s >= sum - s) cnt++;
          }
          return cnt;
      }
  }
- Complexity:  
  - Time: O(n) (single traversal)
  - Space: O(1) (constant space)

2. Longest Subarray with Given Sum k (GeeksforGeeks)
- Problem: Find the length of the longest subarray in `arr` with a sum equal to `k`.
- Approach:
  - Use a HashMap to store prefix sums and their first occurrences.
  - Traverse the array, maintaining a running sum.
  - For each element:
    1. Check if the current sum equals `k`. Update the maximum length.
    2. Check if `sum - k` exists in the map. If it does, calculate the subarray length.
    3. If the current sum is not in the map, store it with its index.
- Code:
  class Solution {
      public int lenOfLongestSubarr(int[] arr, int k) {
          Map<Long, Integer> m = new HashMap<>();
          int max = 0;
          long sum = 0;
          for (int i = 0; i < arr.length; i++) {
              sum += arr[i];
              if (sum == k) max = Math.max(max, i + 1);
              if (m.containsKey(sum - k)) max = Math.max(max, i - m.get(sum - k));
              if (!m.containsKey(sum)) m.put(sum, i);
          }
          return max;
      }
  }
- Complexity:
  - Time: O(n) (single traversal)
  - Space: O(n) (for HashMap)

3. Two Sum (LeetCode)
- Problem: Find indices of two numbers in `nums` that add up to `target`.
- Approach 1 (HashMap):
  - Use a HashMap to store elements and their indices.
  - For each element, check if `target - nums[i]` exists in the map. If yes, return the indices.
- Code:
  class Solution {
      public int[] twoSum(int[] nums, int target) {
          Map<Integer, Integer> m = new HashMap<>();
          for (int i = 0; i < nums.length; i++) {
              if (m.containsKey(target - nums[i])) 
                  return new int[]{m.get(target - nums[i]), i};
              m.put(nums[i], i);
          }
          return new int[0];
      }
  }

- Approach 2 (Two Pointers):
  - Sort the array while keeping track of original indices.
  - Use two pointers to find the pair with the target sum.
- Code:
  class Solution {
      public int[] twoSum(int[] nums, int target) {
          int n = nums.length;
          int[][] arr = new int[n][2];
          for (int i = 0; i < n; i++) {
              arr[i][0] = nums[i];
              arr[i][1] = i;
          }
          Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
          int l = 0, r = n - 1;
          while (l < r) {
              int sum = arr[l][0] + arr[r][0];
              if (sum == target) 
                  return new int[]{arr[l][1], arr[r][1]};
              else if (sum < target) 
                  l++;
              else 
                  r--;
          }
          return new int[0];
      }
  }

- Complexity:
  - HashMap:
    - Time: O(n)
    - Space: O(n)
  - Two Pointers:
    - Time: O(n log n) (due to sorting)
    - Space: O(n)

4. Sort Colors (LeetCode)
- Problem: Sort an array `nums` containing 0s, 1s, and 2s in-place.
- Approach 1 (Counting):
  - Count occurrences of 0, 1, and 2.
  - Rewrite the array based on counts.
- Code:
  class Solution {
      public void sortColors(int[] nums) {
          int cnt0 = 0, cnt1 = 0, cnt2 = 0;
          for (int num : nums) {
              if (num == 0) cnt0++;
              else if (num == 1) cnt1++;
              else cnt2++;
          }
          for (int i = 0; i < cnt0; i++) nums[i] = 0;
          for (int i = cnt0; i < cnt0 + cnt1; i++) nums[i] = 1;
          for (int i = cnt0 + cnt1; i < nums.length; i++) nums[i] = 2;
      }
  }

- Approach 2 (Dutch National Flag Algorithm):
  - Use three pointers (`low`, `mid`, `high`) to segregate 0s, 1s, and 2s.
- Code:
  class Solution {
      public void sortColors(int[] arr) {
          int low = 0, mid = 0, high = arr.length - 1;
          while (mid <= high) {
              if (arr[mid] == 0) {
                  int temp = arr[low];
                  arr[low] = arr[mid];
                  arr[mid] = temp;
                  low++;
                  mid++;
              } else if (arr[mid] == 1) {
                  mid++;
              } else {
                  int temp = arr[mid];
                  arr[mid] = arr[high];
                  arr[high] = temp;
                  high--;
              }
          }
      }
  }

- Complexity:
  - Time: O(n)
  - Space: O(1)
    
Great job solving these problems! 
