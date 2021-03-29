package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;



public class array1 {
    // 移除重复元素
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { // 元素不重复
                i++;  // 计数加一
                nums[i] = nums[j];  // 将不重复的元素放到数组的最前面
            }
        }
        return i + 1;
    }

}
