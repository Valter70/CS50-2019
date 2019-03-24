const val UP_OFFSET = 65
const val LOW_OFFSET = 97

fun main() {
    print("Enter key: ")
    val key = readLine()!!
    var currentKey = 0

    print("Enter plaintext: ")
    val inputText = readLine()!!

    var criptText = ""
    for(i in 0 until inputText.length) {
        when(inputText[i].isLetter()) {
            true -> {
                criptText += getNewChar(inputText[i], getAbsNumber(key[currentKey]))
                if(currentKey < key.length - 1)
                    currentKey++
                else
                    currentKey = 0
            }
            false -> criptText += inputText[i]
        }
    }
    println("cript: $criptText")
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
