import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: _6_59_SpiralMatrixII
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/23 10:13
 * @Version 1.0
 */

/*给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

        示例:

        输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]*/

public class _6_59_SpiralMatrixII {
    @Test
    public void test1() {
        int [][]matrix = generateMatrix(4);
        System.out.println(Arrays.deepToString(matrix));

    }



    public int[][] generateMatrix(int n) {
        //循环不变量原则, 每一圈要画四条边, 每条边都坚持左闭右开

        int[][] nums = new int[n][n];

        //每圈的起始点坐标
        int startX = 0, startY = 0;
        //每条边遍历的偏移量, 因为每条边坚持左闭右开, 所以第一圈每条边都少遍历一个元素, 第二圈少遍历两个元素...
        int offset = 1;
        //应该填入的元素
        int count = 1;
        //记录圈数
        int loop = 1;
        //用于循环中表示坐标, i为行, j为列
        int i, j;

        while (loop <= n / 2) { //n/2为所需的圈数
            //顶边, j变, i不变
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            //右边, i变, j不变
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            //下边, j变, i不变
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            //左边, i变, j不变
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }

            //画完一圈后, 更新参数
            //圈数+1
            loop++;
            //下一圈的offset+1, 因为左闭右开, 所以各边访问的元素数量-1
            offset++;
            //下一圈的起始点坐标+1
            startX++;
            startY++;
        }

        //如果n是奇数, 最后剩下的中心点元素, 直接填充即可
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }

        return nums;
    }
}
