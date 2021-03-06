package com.bignerdranch.nyethack

import com.bignerdranch.nyethack.extensions.random
import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/menu-items.txt")
        .readText()
        .split("\n")

val patronGoldExample1 = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
val patronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>) {

    patronList.add("Andrew")
    patronList.add("Lena")

    for (patron in patronList) {
        println("Hello $patron")
    }

    patronList.replaceAll { patron ->
        patron.toUpperCase()
    }

    patronList.forEachIndexed { index, patron ->
        println("$patron you are ${index + 1} in line")
        placeOrder(patron, menuList.random())
    }

    println(menuList)

    menuList.forEachIndexed { index, data ->
        println("$index: $data")
    }


    (0..9).forEach {
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"

        uniquePatrons.add(name)
    }

    println(uniquePatrons)

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount < 10) {
        placeOrder(uniquePatrons.random(),
                menuList.random())

        orderCount++
    }

    println(patronGold)
    println(patronGold.getOrDefault("Eli", "Not Found"))
    println(patronGold.getOrDefault("Eli2", "Not Found"))
}

fun performPurchaseWithMap(price: Double, patronName: String) {
    val totalPurse = patronGold.getOrDefault(patronName, 0.0)
    patronGold[patronName] = totalPurse - price
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("com.bignerdranch.nyethack.Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    // -----

    val data = menuData.split(",")
    val type = data[0]
    val name = data[1]
    val price = data[2]
    val message = "$patronName buys a $name ($type) for $$price."
    println(message)

    performPurchaseWithMap(price.toDouble(), patronName)

    displayPatronBalance()
    //TODO: Using this to halt execution so output isn't cluttered.

    if (true) {
        return
    }

    performPurchase(price.toDouble())

    val phrase = if (name.toLowerCase() == "Dragons Breath".toLowerCase()) {
        "$patronName exclaims: ${toDragonSpeak("Ah delicious, $name")}"
    } else {
        "$patronName says: Thanks for the $name"
    }

    println(phrase)

    // -----

    //TODO: Using this to halt execution so output isn't cluttered.

    if (true) {
        return
    }

    // -----

    val (type2, name2, price2) = menuData.split(",")
    val message2 = "$patronName buys a $name2 ($type2) for $$price2."
    println(message2)

    // -----

    val phrase0 = "Ah, delicious $name!"
    println("$patronName exclaims: ${toDragonSpeak(phrase0)}")

    // -----

    val phrase2 = if (name.toLowerCase() == "Dragons Breath".toLowerCase()) {
        "$patronName exclaims: ${toDragonSpeak(phrase)}"
    } else {
        "$patronName says: Thanks for the $name"
    }

    println(phrase2)

    val myName = "Andrew"
    var i = 0
    myName.forEach {
        println("$it is the $i char in $myName")
        i++
    }
}

private fun toDragonSpeak(phrase: String) =
        phrase.toLowerCase().replace(Regex("[aeiou]")) {
            when (it.value) {
                "a" -> "4"
                "e" -> "3"
                "i" -> "1"
                "o" -> "0"
                "u" -> "|_|"
                else -> it.value
            }
        }

private fun displayPatronBalance() {
    patronGold.forEach { patron, balance ->
        println("$patron has $balance gold")
    }
}

