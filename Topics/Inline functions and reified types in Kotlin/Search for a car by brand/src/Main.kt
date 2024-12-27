data class Car(val brand: String, val model: String, val year: Int, val price: Double)

inline fun filterByBrand(cars: List<Car>, brand: String): List<Car> {
    return cars.filter { it.brand == brand }
}