import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: _6_454_4SumII
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/24 16:28
 * @Version 1.0
 */

/*给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。

例如:

输入:

A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
输出:

        2

解释:

两个元组如下:

        (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
        (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0*/
public class _6_454_4SumII {
    @Test
    public void test1(){
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //假设四个数组是A,B,C,D
        //先遍历A,B数组，将两数组元素之和存为key，出现次数存为value
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                //如果没出现过i+j则value是0+1，否则就是之前的value+1
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        //count记录符合规定的元组数量，即a+b+c+d=0的数量
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                //如何map中已有a+b能满足a+b+c+d=0，则count记录其出现次数，count就是a+b+c+d=0的数量
                if (map.containsKey(0 - i - j)) {
                    count += map.get(0 - i - j);
                }
            }
        }
        return count;
    }


}
