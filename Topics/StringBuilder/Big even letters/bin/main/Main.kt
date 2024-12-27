fun upperEvenLetters(message: String) = buildString {
        message.forEachIndexed { index, c ->
            if (index % 2 == 0)
                append(c.uppercase())
            else
                append(c) }
    }