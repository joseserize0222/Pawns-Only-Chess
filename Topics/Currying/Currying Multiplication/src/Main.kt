//write your code here
fun multiply(a: Int): (Int) -> (Int) {
    return { x -> a * x }
}