fun main() {
    var cardNumber: String
    do {
        print("Enter card number: ")
        cardNumber = readLine()!!
    } while(!isPositiveDigital(cardNumber) || cardNumber.length < 13)

    val validNumber = isValidLuhn(cardNumber.reversed())

    if(validNumber && isAMEX(cardNumber))
        println("AMEX")
    else if(validNumber && isVISA(cardNumber))
        println("VISA")
    else if(validNumber && isMCARD(cardNumber))
        println("MASTERCARD")
    else
        println("INVALID")
}

fun isAMEX(cardNumber: String) =
    (cardNumber.length == 15) && (cardNumber.substring(0..1).toInt() in setOf(34, 37))

fun isVISA(cardNumber: String) =
        (cardNumber.length in setOf(13, 16)) && cardNumber[0] == '4'

fun isMCARD(cardNumber: String) =
        (cardNumber.length == 16) && (cardNumber.substring(0..1).toInt() in 51..57)

fun isValidLuhn(cardNumber: String) : Boolean {
    var sum = 0
    for(num in 1..cardNumber.length) {
        val n = cardNumber[num - 1].toString().toInt()
        if(num % 2 == 0)
            sum += if(n >= 5) n * 2 - 9 else n * 2
        else
            sum += n
    }
    return sum % 10 == 0
}

fun isPositiveDigital(str: String) : Boolean {
    return isDigital(str) && str.toLong() > 0
}

fun isDigital(str: String) : Boolean {
    for(i in 0 until str.length) {
        if(!str[i].isDigit()) return false
    }
    return true
}