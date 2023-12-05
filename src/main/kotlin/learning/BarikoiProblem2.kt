package learning

fun main() {
    println("Enter test case num: ")
    val testCases = readln().toInt()

    for (i in 1..testCases) {
        val (n, k) = readln().split(" ").map { it.toInt() } // Read n and k
        val s = readln()
        solution(n, k, s)
    }
}

fun solution(n: Int, kk: Int, s: String) {
    var k = kk
    var c = 0
    var c1 = 0
    var c2 = 0

    for (i in n - 1 downTo 0) {
        if (s[i] == '1') {
            if (c == 0 && n - 1 - i <= k) {
                k -= n - 1 - i
                c1++
            }
            c++
        }
    }

    if (c > 1 || (c == 1 && c1 == 0)) {
        for (i in 0 until n) {
            if (s[i] == '1' && k >= i) {
                c2++
                break
            }
        }
    }

    val ans = when {
        c1 >= 1 -> if (c == 1) 1 else if (c2 > 0) (c - 1) * 11 else (c - 1) * 11 + 1
        c == 0 -> 0
        c2 > 0 -> c * 11 - 1
        else -> c * 11
    }

    println(ans)
}