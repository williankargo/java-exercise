package Test.CS61B.Test;


import static org.junit.Assert.*;

import org.junit.Test;

//把SelectionSort分開來test
public class TestSort {

    @Test  //注意：Test時的方法需為non-static!!!
    public void testSelectionSort() {  //整體測試
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};  //由小排到大

        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {  //FindSmallest測試

        //1
        String[] input = {"i", "have", "an", "egg"};

        int expected = 2;
        int actual = SelectionSort.findSmallest(input, 0);

        assertEquals(expected, actual);

        //2
        String[] input2 = {"there", "are", "many", "pigs"};

        int expected2 = 1;
        int actual2 = SelectionSort.findSmallest(input2, 0);

        assertEquals(expected2, actual2);
    }

    @Test
    public void testSwap() {     //Swap測試
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "have", "i", "egg"};

        SelectionSort.swap(input, 0, 2);
        assertArrayEquals(input, expected);
    }
}
