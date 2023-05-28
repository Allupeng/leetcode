

from typing import List

"""
base binary-seach iterative
target in [lo, high]
"""
def binary_search_left_closed_right_closed_iterative(lo: int, hi: int, target: int, nums: List[int]) -> int:
    if lo > hi:
        return -1
    while lo <= hi:
        mid = lo + ((hi - lo) >> 1)
        if nums[mid] < target:
            lo = mid + 1
        elif nums[mid] > target:
            hi = mid - 1
        else:
            return mid
    return -1


"""
base binary-seach recursive
target in [lo, high]
"""
def binary_search_left_closed_right_closed_recursive(lo: int, hi: int, target: int, nums: List[int]) -> int:
    if lo > hi:
        return -1
    mid = lo + ((hi - lo) >> 1)
    if nums[mid] == target:
        return mid
    elif nums[mid] < target:
        return binary_search_left_closed_right_closed_recursive(mid + 1, hi, target, nums)
    else:
        return binary_search_left_closed_right_closed_recursive(lo, mid - 1, target, nums)
    

"""
base binary-seach iterative
target in [lo, high)
"""
def binary_search_left_closed_right_open_iterative(lo: int, hi: int, target: int, nums: List[int]) -> int:
    if lo > hi:
        return -1
    while lo < hi:
        mid = lo + ((hi - lo) >> 1)
        if nums[mid] < target:
            lo = mid + 1
        elif nums[mid] > target:
            hi = mid
        else:
            return mid
    return -1


"""
base binary-seach recursive
target in [lo, high)
"""
def binary_search_left_closed_right_open_recursive(lo: int, hi: int, target: int, nums: List[int]) -> int:
    if lo >= hi:
        return -1
    mid = lo + ((hi - lo) >> 1)
    if nums[mid] == target:
        return mid
    elif nums[mid] < target:
        return binary_search_left_closed_right_open_recursive(mid + 1, hi, target, nums)
    else:
        return binary_search_left_closed_right_open_recursive(lo, mid, target, nums)
    