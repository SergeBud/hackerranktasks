package by.sb.arrays

/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    // Write your code here
    return 0;
}

fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}