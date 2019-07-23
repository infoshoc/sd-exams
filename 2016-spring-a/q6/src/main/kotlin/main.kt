import java.util.*

private val BY_NAME: Comparator<Student> = object : Comparator<Student> {
    override fun compare(l: Student, r: Student): Int =
            l.name.compareTo(r.name)
}

private val BY_YEAR = object : Comparator<Student> {
    override fun compare(l: Student, r: Student): Int =
            l.yearOfBirth.compareTo(r.yearOfBirth)
}

private val BY_GRADE = object : Comparator<Student> {
    override fun compare(l: Student, r: Student): Int =
            l.grade.compareTo(r.grade)
}

private fun run(o: ComplexOrder<Student>) {
    val students = arrayOf(
            Student("B", 1992, 99),
            Student("B", 1992, 80),
            Student("B", 1989, 90),
            Student("A", 1990, 95))
    Arrays.sort(students, o)
    for (curr in students)
        println(curr)
}

fun main(args: Array<String>) {
    val o1 = ComplexOrder.using(BY_NAME)
    val o2 = o1.and(BY_YEAR).and(BY_GRADE)
    val o3 = o2.reverse()
    run(o1)
    run(o2)
    run(o3)
    run(o1)
    run(o2)
    run(o3)
}