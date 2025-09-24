package sorts;

public class Selection implements Sort {
    /**
     * 选择排序算法实现
     * 时间复杂度：最好和最坏情况都是O(n²)
     * 空间复杂度：O(1) - 原地排序
     * 稳定性：不稳定排序算法
     *
     * @param a 待排序的数组
     */
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i; // 未排序序列中最小的元素
            for (int j = i + 1; j < n; j++) {
                if (Sort.less(a[j], a[i]))
                    min = j;
            }
            Sort.exch(a, i, min);
        }
    }
}
