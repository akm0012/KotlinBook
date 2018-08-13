const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {

    val playerName = "Estragon"

    var experiencePoints = 5

    var hasSteed = false

    val drinkOptions = listOf("Mead", "Wine", "LaCroux")

    val bestArrayList: ArrayList<String> = ArrayList()

    bestArrayList.add(drinkOptions[2])

    experiencePoints += 5

    println(experiencePoints)
    println(playerName)
    println("Has Steed: $hasSteed")
    println("Max XP: $MAX_EXPERIENCE")

    println(drinkOptions)
    println("Best Drinks: $bestArrayList")

    println("Does taven have mead? " + drinkOptions.contains("Mead"))

    hasSteed = true

    println("Has Steed: $hasSteed")

    println("Magic Mirror (backwards): " + playerName.reversed())
}

