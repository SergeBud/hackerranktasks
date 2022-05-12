package by.sb.arrays

import java.util.*

fun minimumSwaps(arr: Array<Int>): Int {
    var swap = 0
    IntRange(0, arr.size - 1).forEach { i ->
        if (i + 1 != arr[i]) {
            var t = i
            while (arr[t] != i + 1) {
                t++
            }
            val temp: Int = arr[t]
            arr[t] = arr[i]
            arr[i] = temp
            swap++
        }
    }

    return swap

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}