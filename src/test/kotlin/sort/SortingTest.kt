package sort

import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class SortTest {
    private val expected = arrayOf(1, 2, 2, 3, 4, 5, 6, 7, 8, 9)

    @Test
    fun selectionSort() {
        val sorted = selectionSort(arrayOf(8, 1, 4, 3, 2, 5, 9, 2, 7, 6))
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(expected, sorted))
    }

    @Test
    fun bubbleSort() {
        val sorted = bubbleSort(arrayOf(8, 1, 4, 3, 2, 5, 9, 2, 7, 6))
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(expected, sorted))
    }

    @Test
    fun quickSort() {
        val sorted = quickSort(arrayOf(8, 1, 4, 3, 2, 5, 9, 2, 7, 6))
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(expected, sorted))
    }

    @Test
    fun quickSortRandom() {
        val a = Array(1000) {
            ThreadLocalRandom.current().nextInt()
        }
        val sorted = quickSort(a)
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(a.sorted().toTypedArray(), sorted))
    }

    @Test
    fun quickSortSameValues() {
        val a = Array(10) { 10 }
        val sorted = quickSort(a)
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(a.sorted().toTypedArray(), sorted))
    }

    @Test
    fun quickSortEmpty() {
        val a = arrayOf<Int>()
        val sorted = quickSort(a)
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(arrayOf<Int>(), sorted))
    }

    @Test
    fun quickSortSingleton() {
        val a = arrayOf(5)
        val sorted = quickSort(a)
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(arrayOf<Int>(5), sorted))
    }

    @Test
    fun quickSort2Sorted() {
        val a = arrayOf(5, 6)
        val sorted = quickSort(a)
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(arrayOf(5, 6), sorted))
    }

    @Test
    fun quickSort2Unsorted() {
        val a = arrayOf(6, 5)
        val sorted = quickSort(a)
        println(Arrays.toString(sorted))
        assertTrue(Arrays.equals(arrayOf(5, 6), sorted))
    }
}