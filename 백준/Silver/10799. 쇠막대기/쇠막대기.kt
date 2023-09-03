import java.util.*

fun main() {
    val input = readln()
    val stack = Stack<Char>()
    var last = ' '
    var answer = 0

    for(c in input.toCharArray()) {
        when(c) {
            '(' -> stack.push(c)
            ')' -> {
                stack.pop()

                when(last) {
                    '(' -> answer += stack.size
                    ')' -> answer++
                }
            }
        }

        last = c
    }

    print(answer)
}
