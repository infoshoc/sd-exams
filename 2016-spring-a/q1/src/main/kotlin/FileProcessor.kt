import java.io.BufferedReader
import java.io.FileWriter
import java.io.FileReader
import java.io.File


class FileProcessor {
    fun processFile(inputFile: File, outputFile: File) {
        return processFile(Reader(inputFile), Writer(outputFile))
    }

    fun processFile(reader: Reader, writer: Writer) {
        while (reader.hasNextLine())
            writer.appendLine(processLine(reader.nextLine()))
    }

    fun processLine(str: String): String {
        return str.toLowerCase()
    }
}

open class Reader(inputFile: File) {
    private val reader = FileReader(inputFile)

    fun hasNextLine() = reader.hasNextLine()
    fun nextLine() = reader.nextLine()
}

open class Writer(outputFile: File) {
    private val writer = FileWriter(outputFile)

    fun appendLine(s: String) = writer.appendLine(s)
}

fun FileReader.hasNextLine(): Boolean {
    this.mark(1)
    val has = -1 != this.read()
    this.reset()

    return has
}

fun FileReader.nextLine(): String {
    return BufferedReader(this).readLine()
}

fun FileWriter.appendLine(s: String)  {
    this.write(s)
}
