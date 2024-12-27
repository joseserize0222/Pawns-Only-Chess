class Box<T>(private var value: T) {
    fun add(newValue: T) {
        value = newValue
    }

    fun get(): T = value
}