package by.sb.warmup.task4

import kotlin.math.pow

fun repeatedString(s: String, n: Long): Long {
    // Write your code here
    if (s.isBlank() || s.length > 100) {
        throw RuntimeException("Invalid string length")
    }

    if (n < 1 || n > 10F.pow(12)) {
        throw RuntimeException("Invalid size")
    }

    if (n <= s.length) {
        return countAInString(s, n.toInt())
    }

    val fullStrings = n / s.length
    val lastPart = n.rem(s.length).toInt()

    val res1 = countAInString(s)
    val res2 = countAInString(s, lastPart)

    return fullStrings * res1 + res2
}

fun countAInString(s: String): Long = s.count {
    it == "a".single()
}.toLong()

fun countAInString(s: String, untilIndex: Int): Long {
    var count = 0

    if (untilIndex == 0) {
        return count.toLong()
    }

    val cArr = s.toCharArray()
    IntRange(0, untilIndex - 1).forEach { index ->
        val symbol = cArr[index]
        if ("a".single() == symbol) {
            count++
        }
    }
    return count.toLong()
}

fun main() {
    val s = readLine()!!

    val n = readLine()!!.trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}