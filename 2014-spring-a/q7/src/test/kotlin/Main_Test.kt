import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Main_Tests {
    lateinit var root: Main.Node
    lateinit var firstChild: Main.Node
    lateinit var secondChild: Main.Node

    @BeforeEach
    fun setUp() {
        root = mockk<Main.Node>()
        firstChild = mockk<Main.Node>()
        secondChild = mockk<Main.Node>()
        every{root.firstChild} returns firstChild
        every{firstChild.nextSibling} returns secondChild
        every{secondChild.nextSibling} returns null
        every{firstChild.nodeName} returns Main.A
        every{secondChild.nodeName} returns Main.B
    }

    @Test
    @Throws(Exception::class)
    fun runsGenerators() {
        val main = Main()
        val result = main.compute(root)
        assertEquals(listOf("value_a_1", "value_a_2", "value_b_1"),
                result)
    }

    @Test
    @Throws(Exception::class)
    fun providesAccessByIndexToNamesAndSizes() {
        val main = Main()
        main.compute(root)
        assertEquals(2, main.count)
        assertEquals("name_a:2", main.getSummaryAt(0))
        assertEquals("name_b:1", main.getSummaryAt(1))
        assertEquals("name_a", main.getNameAt(0))
        assertEquals(2, main.getOutputSizeAt(0))
        assertEquals("name_b", main.getNameAt(1))
        assertEquals(1, main.getOutputSizeAt(1))
    }

    @Test
    fun generatorHoldsANode() {
        val na = mockk<Main.Node>()
        val a = Main.GeneratorA(na)
        assertSame(na, a.node)
        val nb = mockk<Main.Node>()
        val b = Main.GeneratorB(nb)
        assertSame(nb, b.node)
    }
}