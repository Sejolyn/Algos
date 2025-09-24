package sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    @Test
    public void SelectSortTest() {
        String[] strings = {"nigger", "stupid", "liuminghao", "waste"};
        assertFalse(Sort.isSorted(strings));
        Sort sort = new Selection();
        sort.sort(strings);
        assertTrue(Sort.isSorted(strings));
    }

    @Test
    public void InsertionTest() {
        String[] strings = {"nigger", "stupid", "liuminghao", "waste"};
        assertFalse(Sort.isSorted(strings));
        Sort sort = new Insertion();
        sort.sort(strings);
        assertTrue(Sort.isSorted(strings));
    }

    @Test
    public void ShellTest() {
        String[] strings = {"nigger", "stupid", "liuminghao", "waste"};
        assertFalse(Sort.isSorted(strings));
        Sort sort = new Shell();
        sort.sort(strings);
        assertTrue(Sort.isSorted(strings));
    }

    @Test
    public void MergeTest() {
        String[] strings = {"nigger", "stupid", "liuminghao", "waste"};
        assertFalse(Sort.isSorted(strings));
        Sort sort = new Merge();
        sort.sort(strings);
        assertTrue(Sort.isSorted(strings));
    }

    @Test
    public void QuickTest() {
        String[] strings = {"nigger", "stupid", "liuminghao", "waste"};
        assertFalse(Sort.isSorted(strings));
        Sort sort = new Quick();
        sort.sort(strings);
        assertTrue(Sort.isSorted(strings));
    }

    @Test
    public void BubbleTest() {
        String[] strings = {"nigger", "stupid", "liuminghao", "waste"};
        assertFalse(Sort.isSorted(strings));
        Sort sort = new Bubble();
        sort.sort(strings);
        assertTrue(Sort.isSorted(strings));
    }
}
