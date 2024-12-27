fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.all { it.uppercase() != "SECRET" }


    println(res)
}