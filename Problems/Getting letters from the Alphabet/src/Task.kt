import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val input = scanner.next()
    val alphabet = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", 
    "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
    loop@ for (i in alphabet) {
        if (i == input) break@loop
        print(i)
    }
}
