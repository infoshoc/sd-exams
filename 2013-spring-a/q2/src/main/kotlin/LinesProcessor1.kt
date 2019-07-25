import java.io.BufferedReader
import java.io.IOException

interface Processor1 {
    fun process(): Boolean
}

class LinesProcessor1(private val br: BufferedReader, val lines: MutableList<String>) : Processor1 {
    override fun process(): Boolean {
        try {
            val line = br.readLine()
            if (null != line) {
                lines.add(line.toLowerCase())
                return true
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return false
    }
}