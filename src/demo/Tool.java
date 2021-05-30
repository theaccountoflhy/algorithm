package demo;

/**
 * Create by hongyan on 2021/5/26
 * 工具类
 * 1.产生随机数组，便于对数器比对public static int[] generateRandomArray(int maxSize, int maxValue)
 * 2.打印数组
 * 3.
 */
public class Tool {


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr){
        if(arr==null || arr.length ==0){
            System.out.println("array is empty");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
