/* Do not change code below */
fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.find { it.endsWith("m") }?.reversed()

    println(res)
}