import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine().split(" ")
    val a = input[0].toInt()
    val b = input[1].toInt()

    bw.write("${a - b}")

    bw.flush()
    bw.close()
    br.close()
}