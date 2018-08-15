fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 95
    var isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

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

    val B = "Blessed: ${if (isBlessed) "YES" else "NO"}"
    val A = "Aura: $auraColor"
    val H = "$name $healthStatus"
    val HP = "HP: $healthPoints"

    println("($HP) ($A) -> $H")
    println("($HP) ($A) ($B) -> $H")

    // Player status
    println("$name $healthStatus")
}