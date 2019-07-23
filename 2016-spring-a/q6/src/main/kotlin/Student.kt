import java.util.Arrays
import java.util.Comparator

class Student(val name: String, val yearOfBirth: Int, val grade: Int) {
    override fun toString(): String {
        return String.format("<%s, %d, %d>", name, yearOfBirth, grade)
    }
}
