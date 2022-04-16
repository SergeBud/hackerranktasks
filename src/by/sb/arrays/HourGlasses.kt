package by.sb.arrays

/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    // Write your code here
    if (arr.size > 6) {
        throw RuntimeException("Invalid size")
    }

    val sums = mutableSetOf<Int>();
    IntRange(0, 3).forEach { rowIndex ->
        IntRange(0, 3).forEach { columnIndex ->
            val elements = listOf(
                arr[rowIndex][columnIndex],
                arr[rowIndex][columnIndex + 1],
                arr[rowIndex][columnIndex + 2],
                arr[rowIndex + 1][columnIndex + 1],
                arr[rowIndex + 2][columnIndex],
                arr[rowIndex + 2][columnIndex + 1],
                arr[rowIndex + 2][columnIndex + 2]
            )

            val sum = elements.filter { validateElement(it) }.sum()
            sums.add(sum)
        }
    }

    return sums.maxOrNull() ?: 0;
}

private fun validateElement(element2: Int): Boolean {
    if (element2 > 9 || element2 < -9) {
        throw RuntimeException("Invalid element")
    }
    return true
}

fun main(args: Array<String>) {

    val arr = Array(6) { Array<Int>(6, { 0 }) }

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}