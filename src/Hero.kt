@file:JvmName("Hero")

import java.io.IOException

fun main(args: Array<String>) {
    val adversary = Jhava()
    println(adversary.utterGreeting())

    val friendshipLevel = adversary.determineFriendshipLevel()
    println(friendshipLevel?.toLowerCase() ?: "It's complicated")

    val adversayHitPoints = adversary.hitPoints
    println(adversayHitPoints.dec())

    println(adversayHitPoints.javaClass)

    adversary.greeting = "Hello, Hero!"
    println(adversary.utterGreeting())

    adversary.offerFood()

    try {
        adversary.extendHandInFriendship()
    } catch (e: Exception) {
        println("Begone! Foul Beast!");
    }

    translator("TEST")
}

val translator = { utterance: String ->
    println(utterance.toLowerCase().capitalize())
}

fun makeProclamation() = "Greetings, beast!"

@JvmOverloads
fun handOverFood(lefthand: String = "berries", rightHand: String = "beef") {
    println("Mmmmm... you hand over some delecious $lefthand and $rightHand.")
}

@Throws(IOException::class)
fun acceptApology() {
    throw IOException()
}

class Spellbook {
    @JvmField
    val spells = listOf("Magic Ms. L", "Lay on Hans")

    companion object {
        @JvmField
        val MAX_SPELL_COUNT = 10

        @JvmStatic
        fun getSpellBookGreeting() = println("I am the Great Grimore!")
    }
}