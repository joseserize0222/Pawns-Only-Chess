fun main() {
    val input = readln().split(" ").asSequence()
    // write your code here
    println(input.count {
        var result = true
        var l = 0
        var r = it.length - 1
        while (r - l >= 1) {
            if (it[l] != it[r]){
                result = false
                break
            }
            l++
            r--
        }
        result
    })
}