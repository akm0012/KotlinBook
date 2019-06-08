const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragons BREATH,5.91")
    placeOrder("shandy,Shirley's Temple,5.91")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    // -----

    val data = menuData.split(",")
    val type = data[0]
    val name = data[1]
    val price = data[2]
    val message = "Madrigal buys a $name ($type) for $$price."
    println(message)

    // -----

    val (type2, name2, price2) = menuData.split(",")
    val message2 = "Madrigal buys a $name2 ($type2) for $$price2."
    println(message2)

    // -----

    val phrase = "Ah, delicious $name!"
    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")

    // -----

    val phrase2 = if (name.toLowerCase() == "Dragons Breath".toLowerCase()) {
        "Madrigal exclaims: ${toDragonSpeak(phrase)}"
    } else {
        "Madrigal says: Thanks for the $name"
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

