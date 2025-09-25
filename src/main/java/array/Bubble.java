package array;

public class Bubble implements Sort {
    /**
     * 冒泡排序算法实现
     * 时间复杂度：最好O(n)，最坏和平均O(n²)
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
        // 每次遍历都会将最大的元素“冒泡”到正确位置
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                if (Sort.less(a[j + 1], a[j])) {
                    Sort.exch(a, j , j + 1);
                }
            }
        }
    }
}
