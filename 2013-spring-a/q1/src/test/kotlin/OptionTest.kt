import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal open class Person(val name: String)
internal class Student(name: String) : Person(name)

class OptionTest {
    @Test
    fun testOption() {
        val of = OptionFactory<Person>()
        val yossi = of.create(Person("Yossi"))
        val py = yossi.getOrElse(Student("Not Yossi"))
        assertEquals("Yossi", py.name)
        val unknown = of.create(null)
        assertTrue(unknown.empty())
        val pny = unknown.getOrElse(Student("Not Yossi"))
        assertEquals("Not Yossi", pny.name)
        val unknown2 = of.create(null)
        assertTrue(unknown === unknown2)
        assertFalse(unknown === yossi)
    }

    @Test
    fun optionTransformation() {
        val  of = OptionFactory<Student>()
        var s = of.create(Student("student_name"))
                .transform{ p -> p.name }
                .getOrElse("_")
        assertEquals("student_name", s);
        s = of.create(null)
                .transform{p -> p.name}
                .getOrElse("_")
        assertEquals("_", s);
    }
}
