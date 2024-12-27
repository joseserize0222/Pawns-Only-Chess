//write your code here
fun concatenate(str1 : String): (String) -> (String) {
    return { str2 -> str1 + str2 }
}