import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readLine())

    val A = st.nextToken().toInt()
    val B = st.nextToken().toInt()

    when {
        A > B -> println(">")
        A < B -> println("<")
        else -> println("==")
    }
}