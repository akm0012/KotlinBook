fun main(args: Array<String>) {
    // Only call capitalize() if realLine provides a non-null value
//    var beverage = readLine()?.capitalize()

//    var beverage = readLine()?.let {
//        if (it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "Buttered Ale"
//        }
//    }

    // Tell the compiler that we know that it will be non null. (Avoid)
//    var beverage = readLine()!!.capitalize()

    var beverage = getNullString()

//    if (beverage != null) {
//        beverage = beverage.capitalize()
//    } else {
//        println("Avoid a NPE")
//    }

    val drinkServed: String = beverage ?: "Beer"


    println(drinkServed)
}

fun getNullString(): String? {
    return null
}

