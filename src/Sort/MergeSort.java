package Sort;

/**
 * @className: MergeSort
 * @description: 归并排序
 * 时间复杂度：O(nlogn)
 * 额外空间复杂度：O(n)
 * 是稳定的，额外空间复杂度可以做成O（1），很难，内部缓存法
 * 主要思想：分治，先使得两个子序列有序，然后在合并使得总体有序
 * @author: hongyan
 * @date: 2021/5/30
 **/
public class MergeSort {
    public static void mergeSort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }

        int mid = (int)((start+end)/2);
        mergeSort(arr,start,mid);
        mergeSort(arr,mid,end);
        merge(arr,start,mid,end);

    }

    public static void merge(int[] arr,int start,int mid,int end){
        return;
    }

}
