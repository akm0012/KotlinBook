fun main(args: Array<String>) {

    println({
        val currentYear = 2018
        "Current year is $currentYear"
    }())

    // ------

    val greeting: () -> String = {
        val currentYear = 2018
        "Current year is $currentYear"
    }

    println(greeting())

    // ------

    val greetPerson: (String, String) -> String = { name: String, role: String ->
        val currentYear = 2018
        "Welcome $name to $currentYear, good luck as a $role"
    }

    println(greetPerson("Andrew", "Lion Tamer"))

    // -----

    val greetPerson2 = { name: String, role: String, numLions: Int ->
        val currentYear = 2018
        "Welcome $name to $currentYear, good luck raising $numLions lions as our resident $role"
    }

    println(greetPerson2("Andrew", "Lion Tamer", 1))

    // -----

    runSimulation("Andrew", ::printPuppyCost, greetPerson2)

    runSimulation("Bob", ::printPuppyCost) { name, role, numPuppies ->
        "Welcome $name, you should have a better time raising $numPuppies puppies as our $role"
    }

    // -----
    printPuppyCost(5)

    var getCount = configFunction()

    getCount()
    getCount()
    getCount()
    getCount()
}

inline fun runSimulation(playerName:String,
                         costPrinter:(Int) -> Unit,
                         greetingFunction: (String, String, Int) -> String){
    val numOfLions = (1..14).shuffled().last()
    println(greetingFunction(playerName, "Tiger wressler", numOfLions))
    costPrinter(numOfLions)
}

fun printPuppyCost(numPuppies: Int) {
    val cost = 1200
    println("It will cost $${numPuppies * cost} to support all $numPuppies puppies.")
}

fun configFunction():() -> Unit {
    var count = 0
    return {
        println("The count is $count")
        count++
    }
}
