import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: _3_349_IntersectionofTwoArrays
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/24 13:26
 * @Version 1.0
 */
public class _3_349_IntersectionofTwoArrays {
    @Test
    public void test1() {
        intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});



    }

    public int[] intersection(int[] nums1, int[] nums2) {
        //使用hashSet解决

        //如果输入的数组为空，返回零数组
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        //将nums1中的元素都添加到set中
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        //将nums1中的元素添加到set1中
        for (int i : nums1) {
            set1.add(i);
        }

        //遍历nums2中的元素，如果与set1中的元素有重叠，就添加到intersectionSet中
        for (int i : nums2) {
            if (set1.contains(i)) {
                intersectionSet.add(i);
            }
        }

        //将intersectionSet转化为array
        int[] arr = new int[intersectionSet.size()];
        int j = 0;
        for (int i : intersectionSet) {
            arr[j] = i;
            j++;
        }

        return arr;
    }
}
