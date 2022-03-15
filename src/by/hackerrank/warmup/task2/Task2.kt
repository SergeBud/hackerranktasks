package by.hackerrank.warmup.task2

import kotlin.math.pow

/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

fun countingValleys(steps: Int, path: String): Int {
    // Write your code here
    if (steps < 2 || steps > 10F.pow(6)) {
        throw RuntimeException("Invalid path")
    }

    var currentHeight = 0
    var prevHeight = 0

    val valueCount = mutableListOf<Int>()

    path.forEach { step ->
        when (step) {
            'U' -> {
                prevHeight = currentHeight
                currentHeight++
            }
            'D' -> {
                prevHeight = currentHeight
                currentHeight--
            }
            else -> throw RuntimeException("Invalid step")
        }

        if ((prevHeight == 0 && currentHeight == -1) || (prevHeight == -1 && currentHeight == 0)) {
            valueCount.add(1)
        }
    }

    return valueCount.size.div(2)
}

fun main(args: Array<String>) {
    println("Insert steps number:")
    val steps = readLine()!!.trim().toInt()

    println("Insert path sequence:")
    val path = readLine()!!

    val result = countingValleys(steps, path)

    println("Result: $result")
}