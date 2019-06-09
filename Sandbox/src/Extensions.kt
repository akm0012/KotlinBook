fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun Int.getRich(amount: Int = 0) = this * (10 * amount)

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

fun Any.sync(extras: String) {
    println(this)
    println("$this and $extras")
}

val String.numVowels
    get() = count { "aeiouy".contains(it) }

infix fun String?.printWithDefault(default: String) =  println(this ?: default)

fun main(args: Array<String>) {
    var bankAccount = 25

    println("Curent Bank Account is $bankAccount")
    println("Get Rich! ${bankAccount.getRich(100)}")

    "Andrew is almost done with this book".easyPrint().addEnthusiasm(50).easyPrint()
    "Andrew is almost done with this book".addEnthusiasm(50).sync("Hello World")
    42.easyPrint()
    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default String with infix"
    nullableString.printWithDefault("Default String without infix")
}