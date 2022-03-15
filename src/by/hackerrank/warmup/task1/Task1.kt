package by.hackerrank.warmup.task1


/*
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    if (n != ar.size) {
        throw RuntimeException("Invalid ar, size not equal")
    }

    val socks = HashMap<Int, MutableList<Int>>()
    ar.forEach { element ->
        var list = socks[element]

        if (list != null) {
            list.add(element)
        } else {
            list = mutableListOf()
            list.add(element)
            socks[element] = list
        }
    }

    var count = 0;

    socks.keys.forEach { element ->
        val list = socks[element]!!
        val lSize = list.size
        if (lSize > 1) {
            count += lSize.div(2)
        }
    }

    return count
}

fun main(args: Array<String>) {
    print("Insert array size:")
    val n = readLine()!!.trim().toInt()

    println()
    print("Insert array elements: ")
    val ar = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    println()
    val result = sockMerchant(n, ar)

    println("Result: $result")
}