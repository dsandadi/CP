package com.company;

import java.util.*;

public class B {
    int[] nums;
    Map<Integer, Map<Integer, List<Integer>>> dp = new HashMap<>();
dfs
    private List<Integer> fa(int st, int maxVal){
        if(st >= nums.length)   return new ArrayList<>();
        if(dp.containsKey(st) && dp.get(st).containsKey(maxVal))
             return dp.get(st).get(maxVal);

        List<Integer> included = new ArrayList<>();
        if(maxVal == -1 || ((nums[st] % maxVal) == 0)){
            included = new ArrayList<>(fa(st + 1, nums[st]));
            included.add(0, nums[st]);
        }

        List<Integer> excluded = fa(st + 1, maxVal); // exclude
        if(maxVal != -1){
            Map<Integer, List<Integer>> mpr2 = dp.getOrDefault(st, new HashMap<>());
            mpr2.put(maxVal,included.size() > excluded.size()? new ArrayList<>(included): new ArrayList<>(excluded));
            dp.put(st, mpr2);
        }

        return included.size() > excluded.size()? new ArrayList<>(included): new ArrayList<>(excluded);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        return fa(0, -1);
    }
}