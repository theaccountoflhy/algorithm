package SwordOffer;

/**
 * Create by hongyan on 2021/5/23
 * 给定一个整形数组arr，已知其中所有的值都是非负的，
 * 将这个数组看作一个容器，请返回容器能装多少水。
 *
 * 例如输入：[3,1,2,5,2,4]
 * 返回值：5
 *
 * 1≤N≤10e6
 *
 * 看答案：每一个位置的液柱高度取决于左边最高多高，右边最高多高
 */
public class NC128 {
    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public static long maxWater (int[] arr) {
        int[] leftmax = leftMax(arr);
        int[] rightmax = rightMax(arr);

        long result =0;
        int temp ;
        int temp2;
        for(int i =0 ; i<arr.length;i++){
            temp = Math.min(leftmax[i],rightmax[i]);
            //三元运算符的优先级非常低
            result = result + (arr[i]>temp?0:(temp-arr[i]));
        }
        return result;

    }

    public static int[] leftMax(int[] arr){
        int[] leftmax = new int[arr.length];
        int temp = 0;
        leftmax[0] = temp;
        for(int i =1; i< arr.length;i++){
            if(temp <  arr[i-1])
                temp = arr[i-1];
            leftmax[i]=temp;
        }
        return leftmax;
    }

    public static int[] rightMax(int[] arr){
        int[] rightmax = new int[arr.length];
        int temp2 = 0;
        rightmax[arr.length-1] = temp2;
        for(int i =arr.length-2; i>=0;i--){
            if(temp2 <  arr[i+1])
                temp2 = arr[i+1];
            rightmax[i]=temp2;
        }
        return rightmax;
    }

    public static void main(String [] Args){
        int[] str = {3,1,2,5,2,4};
        System.out.println(maxWater(str));
    }
}
