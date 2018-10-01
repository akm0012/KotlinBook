fun main(args: Array<String>) {

    runSimulation()
}

inline fun runSimulationOld(playerName: String,
                         costPrinter: (Int) -> Unit,
                         greetingFunction: (String, Int) -> String) {
    val numBuilding = (1..3).shuffled().last() // Randomly selects 1, 2, or 3
    costPrinter(numBuilding)
    println(greetingFunction(playerName, numBuilding))
}

fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Andrew"))
    println(greetingFunction("Andrew"))
}

fun printConstructionCost(numBuilding: Int) {
    val cost = 500
    println("construction cost : ${cost * numBuilding}")
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5

    return {playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (Copyright $currentYear)"
    }

}