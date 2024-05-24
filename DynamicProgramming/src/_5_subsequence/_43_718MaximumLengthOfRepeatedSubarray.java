package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: MaximumLengthOfRepeatedSubarray718
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/13 9:08
 * @Version 1.0
 */
public class _43_718MaximumLengthOfRepeatedSubarray {
    @Test
    public void test1() {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{0,1,3,1,3,2,1}));
    }

    //dp解法
    public int findLength(int[] nums1, int[] nums2) {
        //nums1 与nums2都进行任意删除操作, 得到的最长的公共子序列

        //想到用 二维数组 可以记录两个数组的所有比较情况
        //1. dp[][]含义
        //dp[i][j]: 以nums1[i-1]结尾的数组 和 以nums2[j-1]结尾的数组, 最长重复子数组长度为dp[i][j]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        //3. 初始化
        for (int i = 0; i < nums1.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < nums2.length; i++) {
            dp[0][i] = 0;
        }

        //2. 确定递推公式
//        根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。
        //即, 当以A[i-1] == B[j-1] 时, 看看A[i-2] 与 B[j-2]为结尾的情况, 是否也是相等的.
//        即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
//        根据递推公式可以看出，遍历i 和 j 要从1开始！

        //4. 遍历顺序
        //外层遍历nums1, 内层遍历nums2
        int result = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j], result);
                }

            }
        }
        return result;


    }

    //暴力解法
//    public int findLength(int[] nums1, int[] nums2) {
//        int result = 0; //记录最长子序列的长度, 每次循环都会改变
//        for(int i=0;i<nums1.length;i++){
//            for(int j=0;j<nums2.length;j++){
//                int size =0;//在内侧循环记录 每次循环内部匹配到的子序列长度
//                int m=i, n=j;//表示nums1, nums2的元素位置
//                while(m<nums1.length && n<nums2.length && nums1[m]==nums2[n]){
//                    size++;//子序列长度++
//                    m++;//nums1的下一个元素
//                    n++;//nums2的下一个元素
//                }
//                result = Math.max(result, size);//每次内部循环, 更新result
//            }
//        }
//        return result;
//
//    }

}
