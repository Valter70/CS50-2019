fun main() {
    print("Enter cash with penny: ")
    var cashInPenny = (readLine()!!.toDouble() * 100).toInt()
    val coins = setOf(25, 10, 5, 1)
    var numberOfCoin = 0

    for(coin in coins) {
        numberOfCoin += cashInPenny / coin
        cashInPenny = cashInPenny % coin
    }

    println(numberOfCoin)
}