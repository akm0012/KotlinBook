package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    val player = Player("Andrew222")
    player.castFireball()

    // Aura Color
    val auraColor = player.auraColor()

    // com.bignerdranch.nyethack.Player status
    printPlayerStatus(player = player)

    player.auraColor()

    //These values are computed each time as there is no data backing them
    println(player.diceValue)
    println(player.diceValue)
    println(player.diceValue)
    println(player.diceValue)
    println(player.diceValue)
}

private fun printPlayerStatus(player: Player) {
    println("Aura: ${player.auraColor()} " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

