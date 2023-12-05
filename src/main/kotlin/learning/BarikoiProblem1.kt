package learning

fun main() {
    val n = readln().toInt()
    if (n >= 1 && n >= 100)
        println("N Should be 1 to 100")

    for (i in 1..n) {
        val input = readln().toInt()
        println(findSum(input))
    }
}

fun findSum(number: Int): Int {
    var sum = 0
    var powerOfTwo = 1

    for (i in 1..number) {
        if (i == powerOfTwo) {
            powerOfTwo *= 2
            sum -= i
            continue
        }
        sum += i
    }
    return sum
}