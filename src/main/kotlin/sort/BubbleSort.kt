package sort

import java.util.*

fun insertionSort(data: Array<Int>) {
    for (i in 0 until data.size) {
        for (j in 0 until data.size) {
            if(data[i] < data[j]){
                val tmp = data[i]
                data[i] = data[j]
                data[j] = tmp
            }
        }
    }
}



fun main(args: Array<String>) {
    val array = arrayOf(3, 1, 9, 4, 2, 2, 0, 5)
    insertionSort(array)
    println(Arrays.toString(array))
}