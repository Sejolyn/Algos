package sorts;

import java.util.ArrayList;

public class Quick implements Sort {
    /**
     * 快速排序主方法
     * 时间复杂度：平均O(n log n)，最坏O(n²)
     * 空间复杂度：平均O(log n)，最坏O(n)
     * 稳定性：不稳定排序算法
     *
     * @param a 待排序数组
     */
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(a, left, right); // 划分
        quickSort(a, left, pivotIndex - 1); // 排序左区间
        quickSort(a, pivotIndex + 1, right); // 排序右区间
    }

    /**
     * Lomuto 分区方案
     * 选择最后一个元素作为基准
     */
    private int partition(Comparable[] a, int left, int right) {
       Comparable pivot = a[right]; // 选择最后一个元素作为基准
       int i = left - 1; // i 指向小于 pivot 区间的末尾

       for (int j = left; j < right; j++) {
           if (a[j].compareTo(pivot) <= 0) {
               i++;
               Sort.exch(a, i, j);
           }
       }

       Sort.exch(a, i + 1, right);
       return i + 1;
    }
}
