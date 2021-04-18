package SwordOffer;

import java.util.ArrayList;

/** 顺时针打印矩阵
 * Create by hongyan on 2021/4/18
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 输入：[[1,2],[3,4]]
 * 输出：[1,2,4,3]
 * 算法，参考左神，一圈圈打印，
 * 第一圈00 到ij ，第二圈11 到 i-1 j-1 ，最后一圈为nn 到i-n j-n，此时n = i-n 或 n = j-n
 * 每圈4个while代表四个边
 */
public class JZ19 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int row =0;
        int column =0;
        // a[3][4] 为三行四列二维数组
        int end_row = matrix.length-1;
        int end_column = matrix[matrix.length-1].length-1;
        // 数组长度2 下标01
        ArrayList<Integer> result = new ArrayList<>();

        //使用小于号而不使用！= 排除  0+1 ！= 1-1
        while(row < end_row && column < end_column){
            int x = row;
            int y = column;
            while(y != end_column){
                result .add(matrix[x][y]);
                y++;
            }
            while(x != end_row){
                result .add(matrix[x][y]);
                x++;
            }
            while(y!= column){
                result .add(matrix[x][y]);
                y--;
            }
            while(x != row){
                result .add(matrix[x][y]);
                x--;
            }
            row++;
            end_column--;
            end_row--;
            column++;
        }
        //同行
         if(row == end_row){
             int x = row;
             int y = column;
             //此处小更改，打印完一整行
             while(y != end_column+1){
                 result .add(matrix[x][y]);
                 y++;
             }
             //排除同行且同列情况，避免重复打印，即就一个数
             column= end_column+1;
         }
        //同列
        if(column == end_column){
            int x = row;
            int y = column;
            //此处小更改，打印完一整行
            while(x != end_row+1){
                result .add(matrix[x][y]);
                x++;
            }

        }
        return result;

    }

    public static void main(String[] Args){
        int i[][] = {{1,2},{3,4}};
        System.out.println(printMatrix(i));
    }
}
