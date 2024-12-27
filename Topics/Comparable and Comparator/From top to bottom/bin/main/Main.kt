data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(
        Person("John", 25),
        Person("Sarah", 30),
        Person("David", 20),
        Person("Alice", 40)
    )

    val comparator = Comparator<Person> { p1, p2 -> p1.age - p2.age }

    val sortedPeople = people.sortedWith(comparator.reversed())

    sortedPeople.forEach { println("${it.name}, ${it.age}") }
}