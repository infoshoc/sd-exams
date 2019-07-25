import java.io.BufferedReader

class A2(
        private val p: Processor2
): A {
    override fun processAll(readers: List<BufferedReader>, lines: MutableList<String>): Int {
        var count = 0

        readers.forEach{ reader ->
            while (p.process(reader, lines)) {
                ++count
            }
        }

        return count
    }
}