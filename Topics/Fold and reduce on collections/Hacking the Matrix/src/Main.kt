fun main() {
     val list = readln().split(" ")
    // write your code here
    val res = list.fold(0) { acc, i -> acc + if (i.length >= 4) i.length else 0 }

    println(res)
}