package pac1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {


    /**
     * 首先遍历整个数组，并使用哈希表记录每个数字出现的次数，并形成一个「出现次数数组」。
     * 找出原数组的前 k 个高频元素，就相当于找出「出现次数数组」的前 k 大的值。
     *
     * 最简单的做法是给「出现次数数组」排序。但由于可能有 O(N) 个不同的出现次数（其中 N 为原数组长度），故总的算法复杂度会达到 O(NlogN)，不满足题目的要求。
     *
     * 在这里，我们可以利用堆的思想：建立一个小顶堆，然后遍历「出现次数数组」：
     *
     * 如果堆的元素个数小于 k，就可以直接插入堆中。
     * 如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
     * 遍历完成后，堆中的元素就代表了「出现次数数组」中前 k 大的值。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
