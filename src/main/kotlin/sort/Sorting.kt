package sort

fun selectionSort(a: Array<Int>): Array<Int> {
    for (i in 0 until a.size) {
        var min = a[i]
        var minI = i
        for (j in i until a.size) {
            if (a[j] < min) {
                min = a[j]
                minI = j
            }
        }
        val tmp = a[i]
        a[i] = min
        a[minI] = tmp
    }
    return a
}

fun bubbleSort(a: Array<Int>): Array<Int> {
    do {
        var changed = false
        for (i in 0 until a.size - 1) {
            if (a[i] > a[i + 1]) {
                val tmp = a[i]
                a[i] = a[i + 1]
                a[i + 1] = tmp
                changed = true
            }
        }
    } while (changed)
    return a
}

fun quickSort(a: Array<Int>): Array<Int> {
    quickSort(a, 0, a.size - 1)
    return a
}

private fun quickSort(a: Array<Int>, from: Int, to: Int) {
    if (to > from) {
        val pivot = partition(a, from, to)
        quickSort(a, from, pivot - 1)
        quickSort(a, pivot + 1, to)
    }
}

private fun partition(a: Array<Int>, from: Int, to: Int): Int {
    val pivot = a[from]
    val tmp = a.copyOf()
    var loPointer = from
    var hiPointer = to
    for (i in from + 1..to) {
        if (tmp[i] < pivot) {
            a[loPointer++] = tmp[i]
        } else {
            a[hiPointer--] = tmp[i]
        }
    }
    a[loPointer] = pivot
    return loPointer
}