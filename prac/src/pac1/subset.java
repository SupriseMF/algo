package pac1;

import java.util.ArrayList;
import java.util.List;

public class subset {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(nums[i]);
                res.add(cur);
            }
        }

        return res;
    }


}
