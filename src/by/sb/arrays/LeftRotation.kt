package by.sb.arrays

import java.util.LinkedList
import kotlin.math.pow

fun rotLeft(a: Array<Int>, d: Int, n: Int): Array<Int> {
    // Write your code here
    val till = 10F.pow(5).toInt()
    if (a.size != n || n !in 1..till) {
        throw RuntimeException("Invalid array size")
    }

    if (d !in 1 .. n) {
        throw RuntimeException("Invalid rotate parameter")
    }

    val arrAsList = LinkedList(a.toMutableList())

    repeat(d) {
        val first = arrAsList.pollFirst()
        first?.let {
            if (first < 1 || first > 10F.pow(6).toInt() ) {
                throw RuntimeException("Invalid element value")
            }
            arrAsList.add(it)
        }
    }

    return arrAsList.toTypedArray()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = rotLeft(a, d, n)

    println(result.joinToString(" "))
}