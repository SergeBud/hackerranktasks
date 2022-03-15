package by.sb.warmup.task3

fun jumpingOnClouds(c: Array<Int>): Int {
    val size = c.size
    if (size < 2 || size > 100) {
        throw RuntimeException("Invalid size")
    }

    val first = c[0]
    val last = c[size - 1]
    if (first != last || (first == last && first != 0)) {
        throw RuntimeException("Invalid edge elements")
    }

    var totalSteps = 0
    var stepsMade = 0

    c.forEach { element ->
        if (element != 0 && element != 1) {
            throw RuntimeException("Invalid element")
        }

        if (element == 1 || (element == 0 && stepsMade == 1)) {
            stepsMade = 0
            totalSteps++
        } else if (element == 0 && stepsMade == 0) {
            stepsMade++
        }
    }

    return totalSteps
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val c = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}