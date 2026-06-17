class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums=sorted(nums1+nums2)
        n=len(nums)
        if n%2==0:
            median=(nums[n//2]+nums[n//2-1])/2.0
        else:
            median=float(nums[n//2])
        return median