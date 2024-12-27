import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock


val lock = ReentrantLock()

fun addNumbers(numbers: StringBuilder) {
    for (i in 0 until 100_000) {
        lock.withLock {
            numbers.append(i.toString().first())
        }
    }
}

fun main() {
    val numbers = StringBuilder(200_000)
    val thread = thread(start = false, name = "Thread 1") {
        addNumbers(numbers)
    }

    thread.start()
    addNumbers(numbers)

    thread.join()

    println(numbers.length)
}