package sorts;

public class Insertion implements Sort {
    /**
     * 插入排序算法实现
     * 时间复杂度：最好情况O(n)，最坏和平均情况O(n²)
     * 空间复杂度：O(1) - 原地排序
     * 稳定性：稳定排序算法
     *
     * @param a 待排序数组
     */
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable key = a[i]; // 待插入的元素
            int j = i - 1; // 已排序序列的最后一个元素索引

            // 将比key大的元素向后移动
            while (j >= 0 && Sort.less(key, a[j])) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }
}
