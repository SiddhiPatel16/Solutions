int* nextGreaterElement(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int i, j;
    static int ans[10000];   // or use malloc if required

    *returnSize = nums1Size;

    for (i = 0; i < nums1Size; i++) {
        int index = -1;

        // Find index in nums2
        for (j = 0; j < nums2Size; j++) {
            if (nums1[i] == nums2[j]) {
                index = j;
                break;
            }
        }

        ans[i] = -1;

        // Find next greater
        for (j = index + 1; j < nums2Size; j++) {
            if (nums2[j] > nums1[i]) {
                ans[i] = nums2[j];
                break;
            }
        }
    }

    return ans;
}

