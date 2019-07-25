import java.io.BufferedReader

class A1(
        private val pf: (BufferedReader, MutableList<String>) -> Processor1
): A {
        override fun processAll(readers: List<BufferedReader>, lines: MutableList<String>): Int {
            var count = 0

            readers.map { reader->
                while (pf(reader, lines).process()) {
                    ++count
                }
            }

            return count
        }
}