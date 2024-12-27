fun countUniqueChars(sequence: CharSequence): Int {
    // write your code here
    return sequence.groupBy { it }.size
}