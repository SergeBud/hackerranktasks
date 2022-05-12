package by.sb.arrays

import kotlin.math.pow

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

fun minimumBribes(q: Array<Int>, n: Int, t: Int) {
    // Write your code here
    if (t < 1 || t > 10) {
        throw RuntimeException("Invalid t value")
    }

    if (n < 1 || n > 10F.pow(5).toInt()) {
        throw RuntimeException("Invalid n value")
    }

    val message = "Too chaotic"
    val bribes = HashMap<Int, Int>()
    var tooChaotic = false

    var index = 0
    var needSort = true
    var bribesMadeDuringRun = 0

    // from beginning to end
    while (needSort && index < q.size - 1) {
        val currentItem = q[index]
        val nextIndex = index + 1
        val nextItem = q[nextIndex]

        if (currentItem > nextItem) {
            swapItems(q, currentItem, nextItem, index, nextIndex)
            var elementBribe = bribes.getOrDefault(currentItem, 0)
            elementBribe = elementBribe.inc()

            if (elementBribe > 2) {
                tooChaotic = true
                break
            }

            bribes[currentItem] = elementBribe
            bribesMadeDuringRun += bribesMadeDuringRun.inc()
        }

        index = index.inc()

        // last iteration
        if (index == q.size - 1) {
            if (bribesMadeDuringRun == 0) {
                needSort = false
            }

            if (needSort) {
                index = 0
                bribesMadeDuringRun = 0
            }
        }
    }

    needSort = true
    index = q.size - 1
    bribesMadeDuringRun = 0

    if (tooChaotic) {
        println(message)
        return
    }

    // from end to beginning
    while (needSort && index > 0) {
        val currentItem = q[index]
        val nextIndex = index - 1
        val nextItem = q[nextIndex]

        if (currentItem < nextItem) {
            swapItems(q, currentItem, nextItem, index, nextIndex)
            var elementBribe = bribes.getOrDefault(currentItem, 0)
            elementBribe = elementBribe.inc()

            if (elementBribe > 2) {
                tooChaotic = true
                break
            }

            bribes[currentItem] = elementBribe
            bribesMadeDuringRun += bribesMadeDuringRun.inc()
        }

        index = index.dec()

        // last iteration
        if (index == 0) {
            if (bribesMadeDuringRun == 0) {
                needSort = false
            }

            if (needSort) {
                index = n - 1
                bribesMadeDuringRun = 0
            }
        }
    }

    if (tooChaotic) {
        println(message)
    } else {
        println(bribes.values.sum())
    }
}

fun swapItems(q: Array<Int>, currentItem: Int, nextItem: Int, index: Int, nextIndex: Int) {
    q[index] = nextItem
    q[nextIndex] = currentItem
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        minimumBribes(q, n, t)
    }
}