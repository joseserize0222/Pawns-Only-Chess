fun containsOnlyAlphabets(charSequence: CharSequence): Boolean {
    return charSequence.all { it.isLetter() }
}