fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false

    var inebriationLevel = 0

    // Aura Color
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    // Naming the arguments lets you put them in any order.
    printPlayerStatus(name = "Andrew", auraColor = "Red", healthStatus = "Doing Great!", isBlessed = false)

    println("$name is very ${getInebriationLevel(castFireball(1000))}")
}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String) {
    println("Aura: $auraColor " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String =
        if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String = when (healthPoints) {
    100 -> "is in excellent condition"
    in 90..99 -> "has a few scratches"
    in 75..89 -> {
        if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds"
        }
    }
    in 15..74 -> "looks pretty hurt"
    else -> "is in awful condition!"
}

private fun getInebriationLevel(inebriationLevel: Int = 0) = when (inebriationLevel) {
    in 1..10 -> "tipsy"
    in 11..20 -> "sloshed"
    in 21..30 -> "soused"
    in 31..40 -> "stewed"
    in 41..50 -> "..toasted"
    in 51..Int.MAX_VALUE -> "donezo"

    else -> "sober"
}

private fun castFireball(numFireballs: Int = 2): Int {
    println("A glass of Fireball springs into existence (x$numFireballs)")

    return numFireballs * 3
}
