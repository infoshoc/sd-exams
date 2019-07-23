
import com.sun.org.apache.xpath.internal.operations.Bool
import java.io.File
import java.util.stream.Stream
import kotlin.streams.toList

fun normalize(s: String): String { return s }

private val fileReaderFactory: (String)->FileReader = {FileReader(File(it))}
private val fileWriterFactory: (String)->FileWriter = {FileWriter(File(it))}
private val fileExistsChecker: (String)->Boolean = {File(it).exists()}

class ListPair<T>(
        public val l1: List<T>,
        public val l2: List<T>
) {
    fun <S> map(f: (T)->S): ListPair<S> {
        return ListPair(
                l1.asSequence().map(f).toList(),
                l2.asSequence().map(f).toList()
        )
    }

    fun filter(f: (T) -> Boolean): ListPair<T> {
        val i1 = l1.listIterator()
        val i2 = l2.listIterator()
        val o1 = mutableListOf<T>()
        val o2 = mutableListOf<T>()

        while(i1.hasNext()) {
            val e1 = i1.next()
            val e2 = i2.next()

            if (f(e1) && !f(e2)) {
                o1.add(e1)
                o2.add(e2)
            }
        }

        return ListPair(o1, o2)
    }
}

fun foo(inputFiles: MutableList<String>, outputFiles: MutableList<String>) {
    val ioFiles = ListPair(inputFiles, outputFiles)
            .map(::trimAndLower)
            .filter(fileExistsChecker)
            .map(::normalize)

    val readers = mapToIterator(inputFiles, fileReaderFactory)
    val writers = mapToIterator(outputFiles, fileWriterFactory)

    while (readers.hasNext()) writers.next().write(readers.next().read())
}

private fun trimAndLower(s: String) =
        s.trim { it <= ' ' }.toLowerCase()

private fun <T, S> mapToIterator(list: List<T>, f: (T)->S): Iterator<S> {
    return list.asSequence().map(f).iterator()
}