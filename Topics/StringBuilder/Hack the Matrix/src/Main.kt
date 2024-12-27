fun decodeMessage(encodedMessage: String) = buildString {
    encodedMessage.forEach {
        when(it) {
            in "aeiouAEIOU" -> append(it)
            in 'a' .. 'z' -> append(it.uppercase())
            else -> {}
        }
    }
}