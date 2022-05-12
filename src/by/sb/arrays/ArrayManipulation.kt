package by.sb.arrays

import javax.swing.text.html.HTML.Attribute.N
import kotlin.math.max
import kotlin.math.pow


/*
 * Complete the 'arrayManipulation' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    // Write your code here
    if (n < 3 || n > 10F.pow(7).toInt()) {
        throw RuntimeException("Invalid n")
    }

    if (queries.isEmpty() || queries.size > 2 * 10F.pow(5)) {
        throw RuntimeException("Invalid queries size")
    }

    val array = LongArray(n + 1)

    IntRange(0, queries.size - 1).forEach { queryIndex ->
        val query = queries[queryIndex]

        val a = query[0]
        val b = query[1]
        val k = query[2]

        if (a < 1 || a > n) {
            throw RuntimeException("Invalid A for query=$queryIndex")
        }
        if (b < 1 || b > n || b < a) {
            throw RuntimeException("Invalid B for query=$queryIndex")
        }

        array[a - 1] += (k.toLong())
        array[b] -= (k.toLong())
    }

    var sum: Long = 0
    var max: Long = 0
    for (i in 0 until n) {
        sum += array[i]
        max = max(max, sum)
    }

    return max
}

data class RangeItem(val range: IntRange, val k: Int)

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}