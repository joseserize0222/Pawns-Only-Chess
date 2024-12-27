fun main() {
    val listOfNumbers = readln().split(" ")
    val number = readln().toInt()
    println(listOfNumbers.getOrNull(number))
}