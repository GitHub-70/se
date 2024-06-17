package com.tansun.algorithm.sortalgorithm;

/**
 * 插入排序:其基本思想是将一个元素插入到已经排好序的数组中的合适位置，使得数组仍然保持有序.
 * 1.初始状态：假设有一个包含 n个元素的数组，我们从第二个元素开始（索引为1），
 * 将其视为已排序的序列，而第一个元素视为未排序的序列。
 *
 * 2.逐步插入：从第二个元素开始，逐步将未排序的元素插入到已排序的序列中。具体步骤如下：
 *      取出未排序序列中的一个元素，称之为"当前元素"。
 *      将"当前元素"与已排序序列中的元素依次比较，找到合适的位置插入"当前元素"，使得插入后仍然保持有序。
 *      插入操作涉及将大于"当前元素"的元素依次向后移动一位，直到找到合适的位置。
 *      将"当前元素"插入到找到的位置。
 *
 * 3.重复直至完成：重复上述步骤，直到所有未排序的元素都被插入到已排序序列中，最终得到一个完全有序的数组
 *
 * 优点：
 * 实现简单，代码量小。
 * 对于部分有序的数组，插入排序的效率较高。
 * 空间复杂度较低，只需要常数级的额外空间。
 *
 * 缺点：
 * 时间复杂度较高，最坏情况下需要 O（n^2）次比较和移动操作。
 * 不适用于大规模数据的排序，效率较低。
 * 时间复杂度：最好情况下为 O(n)（当数组已经有序时），最坏情况下为 O（n^2）（当数组逆序时）。
 *
 * 总的来说，插入排序是一种简单且直观的排序算法，适用于小规模数据或部分有序的数据。
 * 在某些特定情况下能够表现出较好的性能。在实际应用中，插入排序常用于数据量较小或已经近乎有序的情况下
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {

            // 未排序的 key 从第二个元素开始取
            int key = arr[i];
            int j = i - 1;

            // 将当前key直到找到合适的位置，插入到已排序的数组 arr[j] 中
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


}
