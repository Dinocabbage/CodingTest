import java.util.*

fun main() {
    val T = readln().toInt()

    repeat(T) {
        val input = readln()
        val stack = Stack<Char>()
        for(c in input.toCharArray()) {
            when(c) {
                '(' -> stack.push(c)
                ')' -> if(!stack.empty()) {
                    stack.pop()
                }
                else {
                    stack.push(' ')
                    break
                }
            }
        }

        when {
            stack.empty() -> println("YES")
            else -> println("NO")
        }
    }
}
