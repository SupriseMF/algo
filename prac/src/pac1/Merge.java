package pac1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {

    public void merge(int[] A, int m, int[] B, int n) {

        int i = m-1;
        int j = n-1;
        int k = m + n-1;
        while (i >=0  && j >= 0) {
            if (A[i] < B[j]) {
                A[k] = B[j];
                k--;
                j--;
            } else {
                A[k] = A[i];
                k--;
                i--;
            }
        }
        while (j >= 0) {
            A[k] = B[j];
            k--;
            j--;
        }
    }


    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        /**
         * 1、按照每个数组的左侧排序
         * 2、比较、合并
         *
         * 时间复杂度O(N*logN）n 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlogn)
         * 空间复杂度O(logN)
          */
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            // 为空，或无相交时，加入
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(intervals[i]);
            } else {
                // 由于已经排好序，只左右合并
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
