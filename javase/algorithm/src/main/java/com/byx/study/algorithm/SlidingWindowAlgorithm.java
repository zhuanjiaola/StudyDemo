package com.byx.study.algorithm;

/**
 * @author wang zhen xing
 * @date 2021/3/11 10:35
 */
public class SlidingWindowAlgorithm {

    public int longestOnes(int[] A, int K) {
        int l = 0, r = 0, res = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                if (K == 0) {
                    while (A[l] == 1) l++;
                    l++;
                } else {
                    K--;
                }
            }
            res = Math.max(res, ++r - l);
        }
        return res;
    }

}
