fun findSerialNumberForGame(listGames: List<String>) {
    val gameIn = readln()
    for (game in listGames) {
        val splitted = game.split("@")
        if (splitted[0] == gameIn) {
            println("Code for Xbox - ${splitted[1]}, for PC - ${splitted[2]}")
            break
        }
    }
}