class Solution {
    public void sortColors(int[] arr) {
        int n=arr.length,i;
        int low=0,mid=0,high=n-1;
        while(mid<=high)
        {
            if(arr[mid]==0)
            {
                int t=arr[low];
                arr[low]=arr[mid];
                arr[mid]=t;
                low++;
                mid++;
            }
            else if(arr[mid]==1)
                mid++;
            else
            {
                int t=arr[mid];
                arr[mid]=arr[high];
                arr[high]=t;
                high--;
            }
        }
    }
}