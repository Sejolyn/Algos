package sorts;

public class Shell implements Sort {
    /**
     * 希尔排序算法实现
     * 时间复杂度：依赖于间隔序列，最坏情况O(n²)，最好情况O(n log n)
     * 空间复杂度：O(1) - 原地排序
     * 稳定性：不稳定排序算法
     *
     * @param a 待排序的数组
     */
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int n = a.length;

        // gap 每次缩小一半
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 从第gap个元素开始
            for (int i = gap; i < n; i++) {
                Comparable temp = a[i]; // 当前需要插入的元素
                int j;

                // 对当前分组进行插入排序
                for (j = i; j >= gap && Sort.less(temp, a[j - gap]); j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = temp;
            }
        }
    }
}
