class Barrel<in T>(item:T)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("A hat", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    fedoraBarrel = lootBarrel

//    lootBarrel = fedoraBarrel
//    val myFedora: Fedora = lootBarrel.item
}