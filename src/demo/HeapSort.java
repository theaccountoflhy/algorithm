package demo;

import java.util.Queue;

/**
 * Create by hongyan on 2021/5/26
 * 堆排序，数组完全二叉树
 * 首先实现大根堆小根堆(不使用优先级队列)
 */
public class HeapSort {

    /**
     *
     * @param arr
     */
    public static void heapSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }

        // 自下而上构建大根堆
        for(int i =0 ; i<arr.length;i++){
            heapInsert(arr,i);
        }
        int end = arr.length-1;

        while(end>=1 ){
            Tool.swap(arr,0,end--);
            heapify(arr,0,end+1);
        }

    }

    /**
     * 从下而上调整二叉树，构造出大根堆
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr,int index){
        while( arr[index] > arr[(index-1)/2]){
            Tool.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 当二叉树某一个值发生变化时自上而下调整二叉树
     * @param arr 需要调整的数组
     * @param index 开始调整的索引，决定了那颗子树
     * @param size 调整的最大范围
     */
    public static void heapify(int[] arr, int index, int size){
        int left = index*2 +1;
        while(left < size){  //索引和大小是有1的差别的，不使用<=
            //先比较左右节点（如果有右的话），取最大值
            int largest = left+1<size && arr[left+1]>arr[left]?left+1:left;
            largest = arr[largest]> arr[index] ? largest: index;
            if(largest == index){
                break;
            }
            Tool.swap(arr,index,largest);
            index = largest;
            left = index*2 +1;
        }
    }

    public static void main(String[] Args){
        int[] arr = Tool.generateRandomArray(10, 10);
        Tool.printArray(arr);
        heapSort(arr);
        Tool.printArray(arr);
    }
}
