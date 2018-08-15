fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 95
    var isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
//    val auraColor = if (auraVisible) "GREEN" else "NONE"

    // I don't think this equation is right, have not seen a Karma below 11 yet
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    println("You have $karma karma...")

    val auraColor = when (karma) {
        in 0..5 -> "Red"
        in 6..10 -> "Orange"
        in 11..15 -> "Purple"
        in 16..20 -> "Green"
        else -> "Unknown"
    }

    if (auraVisible) {
        println("Your aura is a brilliant $auraColor glow!")
    }

    println("Aura: $auraColor " +
        "(Blessed: ${if (isBlessed) "YES" else "NO"})")

    val healthStatus = when (healthPoints) {
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

    // Player status
    println("$name $healthStatus")
}