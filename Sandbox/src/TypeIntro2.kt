fun main(args: Array<String>) {


    for (i in 1..10) {
        val diceRoll = (1..7).toList().shuffled().first()
        val message = "You rolled a $diceRoll, that is " + evaluateDice(isCaps = true, numberRolled = diceRoll)
        println(message)
        println(String.format("The last line had %s spaces in it", message.count { letter -> letter == ' ' }))

    }


}

fun saveForLater(age: Int): Nothing {
    throw IllegalStateException("Do this later")
}

fun returnAnInt(): Int {
    saveForLater(1)
}

fun evaluateDice(numberRolled: Int, isCaps: Boolean) =
        when (numberRolled) {
            in 0..2 -> if (isCaps) "not a great roll".toUpperCase() else "not a great roll"
            in 3..4 -> "A decent roll"
            in 5..6 -> "A Great roll!"
            else -> "one of those nerd dice!"
        }
