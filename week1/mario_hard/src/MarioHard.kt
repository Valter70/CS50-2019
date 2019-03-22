fun main() {

    var inputStr: String

    do {
        print("Enter number of lines: ")
        inputStr = readLine()!!
    } while(!isPositiveDigital(inputStr))

    val numberOfLines = inputStr.toInt()

    for(line in 1..numberOfLines) {
        val numberOfSpace = numberOfLines - line
        for(space in 1..numberOfSpace) {
            print(" ")
        }
        for(space in numberOfSpace until numberOfLines) {
            print("#")
        }
        print("  ")
        for(space in numberOfSpace until numberOfLines) {
            print("#")
        }
        println("")
    }
}


fun isPositiveDigital(str: String) : Boolean {
    return isDigital(str) && str.toInt() > 0
}

fun isDigital(str: String) : Boolean {
    for(i in 0 until str.length) {
        if(str[i] !in '0'..'9') return false
    }
    return true
}