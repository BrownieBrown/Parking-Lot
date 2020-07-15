import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val xRows = mutableListOf<Int>()
    val yColumns = mutableListOf<Int>()
    val x1 = input.nextInt()
    val y1 = input.nextInt()
    val x2 = input.nextInt()
    val y2 = input.nextInt()
    val x3 = input.nextInt()
    val y3 = input.nextInt()

    for (i in 1..5){
        if (i == x1 || i == x2 || i == x3) continue else xRows.add(i)
    }
    for (j in 1..5){
        if (j == y1 || j == y2 || j == y3) continue else yColumns.add(j)
    }
    println(xRows.joinToString(" "))
    println(yColumns.joinToString(" "))
}