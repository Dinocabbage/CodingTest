import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val l = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val chars = readln().replace(" ", "").toCharArray()

    chars.sort()

    fun findPassword(length: Int, index: Int, vowel: Int, consonants: Int, password: String) {
        if(length == l) {
            if(vowel >= 1 && consonants >= 2) {
                println(password)
            }

            return
        }

        for(i in index until c) {
            val tmp = chars[i]

            when(tmp) {
                'a', 'e', 'i', 'o', 'u' -> findPassword(length + 1, i + 1, vowel + 1, consonants, password + tmp)
                else -> findPassword(length + 1, i + 1, vowel, consonants + 1, password + tmp)
            }
        }
    }

    findPassword(0, 0, 0, 0, "")
}
