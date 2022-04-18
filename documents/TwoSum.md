# 1.TwoSum

## Description

Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.

You may assume that each input would have ***exactly\* one solution**, and you may not use the *same* element twice.

You can return the answer in any order.

## 思路

定义一个map，key值存放值，value存放索引。遍历给定的数组，使用目标值target减去当前遍历的值，若target-num[i]在map中能够找到，那么将map的key值和当前遍历的nums[i]插入到返回数组中；若target-num[i]在map中不能找到，则将num[i]与i插入map。

## 代码

```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> mymap;
        vector<int> res;

        for(int i=0;i<nums.size();i++)
        {
            //mymap.insert(make_pair(nums[i],i)); 
     
            if(mymap.count(target - nums[i]))
            {
                map<int, int>::iterator it = mymap.find(target - nums[i]);
                res.push_back(i);
                res.push_back(it->second);
                break;
            }
            mymap.insert(make_pair(nums[i],i)); 
        }       
        return res;
    }
};
```

