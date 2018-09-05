fun main(args: Array<String>) {

    val greetingFunction = {playerName: String, numBuildings: Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome $playerName to SimVillage, Mayer! (copyright $currentYear)"
    }

    runSimulation("Andrew", greetingFunction)

    // These are equal, just shorthand.

    runSimulation("Andrew") { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome $playerName to SimVillage, Mayer! (copyright $currentYear)"
    }
}

fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuilding = (1..3).shuffled().last() // Randomly selects 1, 2, or 3
    println(greetingFunction(playerName, numBuilding))
}