import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`).next().toLowerCase()
    val charArray = input.toCharArray()
    for (character in 'a'..'z') {
        if (charArray.contains(character)) continue
        print(character)
    }
}