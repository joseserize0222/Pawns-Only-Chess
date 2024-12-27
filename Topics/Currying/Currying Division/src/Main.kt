//write your code here
fun divide(a: Int): (Int) -> (Double) {
    return { b -> (a / b).toDouble() }
}