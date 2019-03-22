const val UP_OFFSET = 65
const val LOW_OFFSET = 97

fun main() {
    var inputStr: String
    do {
        print("Enter key: ")
        inputStr = readLine()!!
    } while(!isPositiveDigital(inputStr))

    val key = inputStr.toInt()

    print("plaintext: ")
    val oldString = readLine()!!

    var newString = ""

    for(i in 0 until oldString.length) {
        when(oldString[i].isLetter()) {
            true -> newString += getNewChar(oldString[i], key)
            false -> newString += oldString[i]
        }
    }

    println("ciphertext: $newString")
}

fun getNewChar(ch: Char, key: Int) =
    when(ch.isLowerCase()) {
        true -> ((getAbsNumber(ch) + key) % 26 + LOW_OFFSET).toChar()
        false -> ((getAbsNumber(ch) + key) % 26 + UP_OFFSET).toChar()
    }

fun getAbsNumber(ch: Char) =
    when(ch.isLowerCase()) {
        true -> (ch - LOW_OFFSET).toInt()
        false -> (ch - UP_OFFSET).toInt()
    }

fun isPositiveDigital(str: String) : Boolean {
    return isDigital(str) && str.toInt() > 0
}

fun isDigital(str: String) : Boolean {
    for(i in 0 until str.length) {
        if(!str[i].isDigit()) return false
    }
    return true
}