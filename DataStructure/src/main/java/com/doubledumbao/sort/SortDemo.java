package com.doubledumbao.sort;


import java.util.Arrays;

/**
 * 排序算法
 *
 * @author doubledumbao
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {2, 13, 7, 5, 98, 67, 34, 23, 87, 102, 19, 77};
        System.out.println(Arrays.toString(arr));
        //冒泡排序
        //bubbleSort(arr);
        //选择排序
        //selectSort(arr);
        //插入排序
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * <p>
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 算法描述
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     * 稳定性
     * 在相邻元素相等时，它们并不会交换位置，所以，冒泡排序是稳定排序。
     * <p>
     * 适用场景
     * 冒泡排序思路简单，代码也简单，特别适合小数据的排序。但是，由于算法复杂度较高，在数据量大的时候不适合使用。
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 选择排序
     * <p>
     * 选择排序是一种简单直观的排序算法，它也是一种交换排序算法，和冒泡排序有一定的相似度，可以认为选择排序是冒泡排序的一种改进。
     * <p>
     * 算法描述
     * 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 重复第二步，直到所有元素均排序完毕。
     * 稳定性
     * 用数组实现的选择排序是不稳定的，用链表实现的选择排序是稳定的。
     * 不过，一般提到排序算法时，大家往往会默认是数组实现，所以选择排序是不稳定的。
     * <p>
     * 适用场景
     * 选择排序实现也比较简单，并且由于在各种情况下复杂度波动小，因此一般是优于冒泡排序的。
     * 在所有的完全交换排序中，选择排序也是比较不错的一种算法。
     * 但是，由于固有的O(n2)复杂度，选择排序在海量数据面前显得力不从心。因此，它适用于简单数据排序。
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //临时变量，交换值时临时存储数据
        int temp = 0;
        //最小数值对应的坐标
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }


    /**
     * 插入排序
     * <p>
     * 插入排序是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * <p>
     * 算法描述
     * 把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
     * 从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
     * 重复上述过程直到最后一个元素被插入有序子数组中。
     * 稳定性
     * 由于只需要找到不大于当前数的位置而并不需要交换，因此，直接插入排序是稳定的排序方法。
     * <p>
     * 适用场景
     * 插入排序由于O( n2 )的复杂度，在数组较大的时候不适用。但是，在数据比较少的时候，是一个不错的选择，一般做为快速排序的扩充。
     * 例如，在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，用于少量元素的排序。
     * 又如，在JDK 7 java.util.Arrays所用的sort方法的实现中，当待排数组长度小于47时，会使用插入排序。
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //当前带排序的值
            int value = arr[i];
            //位置指针，初始指向当前位置
            int position = i;
            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = value;
        }
    }


}


