import java.io.BufferedReader
import java.io.IOException

interface Processor2 {
    fun process(br: BufferedReader, lines: MutableList<String>): Boolean
}

class LinesProcessor2 : Processor2 {
    override fun process(br: BufferedReader, lines: MutableList<String>): Boolean {
        try {
            val line = br.readLine()
            if (line != null) {
                lines.add(line.toLowerCase())
                return true
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return false
    }
}