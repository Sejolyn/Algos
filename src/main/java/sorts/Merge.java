package sorts;

public class Merge implements Sort {
    /**
     * 归并排序算法实现
     * 时间复杂度：O(n log n) - 最好、最坏、平均情况都是O(n log n)
     * 空间复杂度：O(n) - 需要额外的临时数组
     * 稳定性：稳定排序算法
     *
     * @param a 待排序的数组
     */
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        Comparable[] temp = new Comparable[a.length];
        sort(a, 0, a.length - 1, temp);
    }

    /**
     * 递归分治方法
     * @param a 原始数组
     * @param left 左边界
     * @param right 右边界
     * @param temp 临时数组
     */
    private void sort(Comparable[] a, int left, int right, Comparable[] temp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2; // 防止整数溢出
        sort(a, left, mid, temp); // 递归排序左半部分
        sort(a, mid + 1, right, temp); // 递归排序右半部分
        merge(a, left, mid, right, temp); // 合并两个有序数组
    }

    /**
     * 合并两个有序子数组
     * @param a 原始数组
     * @param left 左边界
     * @param mid 中间位置
     * @param right 右边界
     * @param temp 临时数组
     */
    private void merge(Comparable[] a, int left, int mid, int right, Comparable[] temp) {
        int i = left; // 左子数组起始索引
        int j = mid + 1; // 右子数组起始索引
        int k = 0;

        // 比较两个子数组的元素，将较小的放入temp数组
        while (i <= mid && j <= right) {
            if (a[i].compareTo(a[j]) <= 0) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 将左子数组剩余元素复制到temp
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        // 将右子数组剩余元素复制到temp
        while (j <= right) {
            temp[k++] = a[j++];
        }

        // 将temp复制回原数组
        k = 0;
        while (left <= right) {
            a[left++] = temp[k++];
        }
    }
}
