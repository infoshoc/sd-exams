import java.io.BufferedReader

interface A {
    /**
     * Reads all lines from all of the given readers
     * and adds them into the given list of strings after processing. * @param readers
     * Input readers.
     * @param lines
     * The output collection where the processed lines are
     * stored. * @return
     * Count of lines successfully read
     * from the input readers.
     */
    fun processAll(readers: List<BufferedReader>, lines: MutableList<String>): Int
}