data class Student(val name: String, val grade: Int) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return other.grade - grade
    }
}